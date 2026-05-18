import json
import sys
from pathlib import Path
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# ==================== 配置 ====================
SARIF_DIR = Path("qwen_output_coder_independent")
LANGUAGES = {
    "python": "Python",
    "cpp": "C++",
    "java": "Java",
}
SARIF_FILES = {lang: SARIF_DIR / f"{lang}-results.sarif" for lang in LANGUAGES}
OUTPUT_HEATMAP = "vulnerability_heatmap_coder.png"
OUTPUT_CSV = "vulnerability_summary_coder.csv"
# ==============================================

def parse_sarif(file_path: Path, language: str):
    """解析单个 SARIF 文件，返回 (规则ID, 语言, 文件路径) 列表"""
    if not file_path.exists():
        print(f"⚠️ 文件不存在: {file_path}")
        return []

    with open(file_path, "r", encoding="utf-8") as f:
        data = json.load(f)

    records = []
    for run in data.get("runs", []):
        tool_name = run.get("tool", {}).get("driver", {}).get("name", "unknown")
        for result in run.get("results", []):
            rule_id = result.get("ruleId", "None")
            # 提取 CWE 编号或规则名
            cwe = rule_id.split("/")[-1] if "/" in rule_id else rule_id
            # 提取文件位置
            locations = result.get("locations", [])
            file_path = ""
            if locations:
                phys = locations[0].get("physicalLocation", {})
                artifact = phys.get("artifactLocation", {}).get("uri", "")
                file_path = artifact
            records.append({
                "Language": language,
                "Rule": cwe,
                "File": file_path,
                "Tool": tool_name,
            })
    return records

def main():
    all_records = []
    for lang_key, lang_name in LANGUAGES.items():
        path = SARIF_FILES[lang_key]
        if not path.exists():
            print(f"❌ 未找到 {lang_name} 的 SARIF 文件: {path}")
            continue
        print(f"📖 解析 {lang_name} 报告...")
        records = parse_sarif(path, lang_name)
        print(f"   发现 {len(records)} 个漏洞条目")
        all_records.extend(records)

    if not all_records:
        print("❌ 没有任何漏洞数据，无法生成热力图。将创建空图。")
        # 创建空数据框
        heatmap_data = pd.DataFrame(0, index=["Python", "C++", "Java"], columns=["No vulnerabilities"])
    else:
        df = pd.DataFrame(all_records)
        # 统计每种语言下每种漏洞的数量
        heatmap_data = df.groupby(["Language", "Rule"]).size().unstack(fill_value=0)

    # 保存统计 CSV
    heatmap_data.to_csv(OUTPUT_CSV, encoding="utf-8")
    print(f"📊 漏洞统计已保存到 {OUTPUT_CSV}")

    # 绘制热力图
    plt.figure(figsize=(max(12, len(heatmap_data.columns) * 0.6), max(4, len(heatmap_data) * 0.8)))
    sns.heatmap(heatmap_data, annot=True, fmt="d", cmap="YlOrRd", linewidths=0.5, cbar_kws={'label': 'Vulnerability Count'})
    plt.title("Qwen2.5-Coder-7B: CodeQL Vulnerability Density Heatmap")
    plt.ylabel("Programming Language")
    plt.xlabel("CWE / Security Rule")
    plt.tight_layout()
    plt.savefig(OUTPUT_HEATMAP, dpi=300)
    plt.show()
    print(f"✅ 热力图已保存为 {OUTPUT_HEATMAP}")

if __name__ == "__main__":
    main()