import json
import csv
from pathlib import Path

# ================= 配置 =================
EXTRACTED_DIR = Path("./extracted_code")
# 可选：输出汇总 CSV（所有结果合并）
SUMMARY_CSV = "codeql_summary.csv"
# =========================================

def parse_sarif(sarif_path):
    """解析单个 SARIF 文件，返回漏洞记录列表"""
    records = []
    with open(sarif_path, "r", encoding="utf-8") as f:
        data = json.load(f)

    # 从文件名推断语言和有效性类别（例如 valid_python_results.sarif）
    stem = sarif_path.stem                    # 不含扩展名
    parts = stem.split("_")
    validity = parts[0] if len(parts) >= 2 else "unknown"
    lang = parts[1] if len(parts) >= 2 else "unknown"

    for run in data.get("runs", []):
        for result in run.get("results", []):
            rule_id = result.get("ruleId", "")
            message = result.get("message", {}).get("text", "")
            # 取第一个位置
            location = result.get("locations", [{}])[0]
            physical = location.get("physicalLocation", {})
            file_uri = physical.get("artifactLocation", {}).get("uri", "")
            start_line = physical.get("region", {}).get("startLine", "")
            records.append({
                "validity": validity,
                "language": lang,
                "file": file_uri,
                "rule": rule_id,
                "line": start_line,
                "message": message,
            })
    return records, validity, lang

def main():
    all_records = []   # 用于汇总 CSV

    # 遍历所有模型目录下的 codeql_results
    for model_dir in EXTRACTED_DIR.glob("extracted_*"):
        result_dir = model_dir / "codeql_results"
        if not result_dir.exists():
            continue

        model_name = model_dir.name
        for sarif_file in result_dir.glob("*.sarif"):
            print(f"处理 {sarif_file} ...")
            records, validity, lang = parse_sarif(sarif_file)

            if not records:
                print(f"  无漏洞记录。")
                continue

            # 添加模型信息
            for rec in records:
                rec["model"] = model_name
            all_records.extend(records)

            # 生成单独的 CSV（与 sarif 同目录、同名，扩展名 .csv）
            csv_file = sarif_file.with_suffix(".csv")
            with open(csv_file, "w", newline="", encoding="utf-8") as f:
                writer = csv.DictWriter(f, fieldnames=records[0].keys())
                writer.writeheader()
                writer.writerows(records)
            print(f"  单独报告已生成：{csv_file} ({len(records)} 条)")

    # 生成汇总 CSV
    if all_records:
        with open(SUMMARY_CSV, "w", newline="", encoding="utf-8") as f:
            writer = csv.DictWriter(f, fieldnames=all_records[0].keys())
            writer.writeheader()
            writer.writerows(all_records)
        print(f"汇总报告已生成：{SUMMARY_CSV} (共 {len(all_records)} 条记录)")
    else:
        print("未在任何 SARIF 中发现漏洞记录。")

if __name__ == "__main__":
    main()