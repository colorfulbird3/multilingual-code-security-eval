"""
构建 P-Tuning v2 训练数据（模型专属版本）
- 正例：DeepSeek 审计为 "Safe" 的代码
- 负例：DeepSeek 审计为 "Vulnerable" 的代码
- 每个样本包含 prompt（从 CodeSecBenchHub 读取）和 completion（从 extracted_code 读取）
- 输出 JSON 文件到 E:\multilingual-code-security-eval\prefix tunninghub\

用法：修改 MODEL_NAME 相关变量后运行
"""
import json
import csv
import re
from pathlib import Path

# ================= 配置 =================
# 选择要构建哪个模型的数据
MODEL_EXTRACTED_DIR = Path("extracted_code/extracted_qwen_output_coder_7b")
CSV_FILE = "extracted_code/deepseek_vulnerability_report_extracted_qwen_output_coder_7b_full.csv"
DATASET_ROOT = Path("CodeSecBenchHub")
OUTPUT_DIR = Path(r"E:\multilingual-code-security-eval\prefix tunninghub")
OUTPUT_JSON = OUTPUT_DIR / "prefix_train_data_qwen7b.json"

POSITIVE_RATIO = 0.8
MIN_SAMPLES_PER_LANG = 500        # 每种语言至少的样本总数（可调高）
# =========================================


def find_prompt_file(code_filename, lang):
    """根据生成代码的文件名，在 CodeSecBenchHub 中查找原始提示文件"""
    match = re.match(r"(.+)\.generated\.\w+$", code_filename)
    if not match:
        return None
    prompt_name = match.group(1)
    search_dir = DATASET_ROOT / lang
    for fpath in search_dir.rglob(prompt_name):
        return fpath
    return None


def main():
    OUTPUT_DIR.mkdir(parents=True, exist_ok=True)

    safe_files = []
    vuln_files = []
    with open(CSV_FILE, "r", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        for row in reader:
            if row["status"] == "Safe":
                safe_files.append(row["file"])
            elif row["status"] == "Vulnerable":
                vuln_files.append(row["file"])

    print(f"找到 {len(safe_files)} 个 Safe 文件, {len(vuln_files)} 个 Vulnerable 文件")

    lang_samples = {"python": {"safe": [], "vuln": []},
                    "cpp": {"safe": [], "vuln": []},
                    "java": {"safe": [], "vuln": []}}

    for fpath_str in safe_files:
        p = Path(fpath_str)
        lang = p.parent.parent.name
        if lang in lang_samples:
            lang_samples[lang]["safe"].append(p)
    for fpath_str in vuln_files:
        p = Path(fpath_str)
        lang = p.parent.parent.name
        if lang in lang_samples:
            lang_samples[lang]["vuln"].append(p)

    train_data = []
    for lang, samples in lang_samples.items():
        total_available = len(samples["safe"]) + len(samples["vuln"])
        if total_available == 0:
            continue

        n_total = max(MIN_SAMPLES_PER_LANG, total_available)
        n_positive = min(int(n_total * POSITIVE_RATIO), len(samples["safe"]))
        n_negative = n_total - n_positive
        n_negative = min(n_negative, len(samples["vuln"]))

        print(f"语言 {lang}: 正例 {n_positive} (可用 {len(samples['safe'])}), 负例 {n_negative} (可用 {len(samples['vuln'])})")

        selected_safe = samples["safe"][:n_positive]
        selected_vuln = samples["vuln"][:n_negative]

        for code_path in selected_safe + selected_vuln:
            try:
                code = code_path.read_text(encoding="utf-8")
            except Exception:
                continue
            prompt_file = find_prompt_file(code_path.name, lang)
            if prompt_file is None:
                print(f"⚠️ 找不到提示文件 for {code_path.name}")
                continue
            prompt_text = prompt_file.read_text(encoding="utf-8")
            train_data.append({"prompt": prompt_text, "completion": code})

    with open(OUTPUT_JSON, "w", encoding="utf-8") as f:
        json.dump(train_data, f, ensure_ascii=False, indent=2)
    print(f"✅ 训练数据已保存至 {OUTPUT_JSON}，共 {len(train_data)} 条")


if __name__ == "__main__":
    main()