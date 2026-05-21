import json
import csv
from pathlib import Path
from concurrent.futures import ThreadPoolExecutor, as_completed

# ================= 配置 =================
EXTRACTED_DIR = Path("./extracted_code")
MAX_WORKERS = 8          # 并发线程数（SARIF 解析极轻量，可设大一些）
SUMMARY_CSV = "codeql_summary.csv"
# =========================================

def parse_sarif(sarif_path):
    """解析单个 SARIF 文件，返回漏洞记录列表，如果目标 CSV 已存在则跳过并返回 None"""
    csv_file = sarif_path.with_suffix(".csv")
    if csv_file.exists():
        return None  # 跳过，不处理

    records = []
    with open(sarif_path, "r", encoding="utf-8") as f:
        data = json.load(f)

    stem = sarif_path.stem
    parts = stem.split("_")
    validity = parts[0] if len(parts) >= 2 else "unknown"
    lang = parts[1] if len(parts) >= 2 else "unknown"

    for run in data.get("runs", []):
        for result in run.get("results", []):
            rule_id = result.get("ruleId", "")
            message = result.get("message", {}).get("text", "")
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

    # 保存单独的 CSV
    with open(csv_file, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=records[0].keys() if records else [])
        if records:
            writer.writeheader()
            writer.writerows(records)
    return records, sarif_path

def main():
    all_records = []
    tasks = []

    # 收集所有 SARIF 文件
    for model_dir in EXTRACTED_DIR.glob("extracted_*"):
        result_dir = model_dir / "codeql_results"
        if not result_dir.exists():
            continue
        model_name = model_dir.name
        for sarif_file in result_dir.glob("*.sarif"):
            tasks.append((sarif_file, model_name))

    total = len(tasks)
    if total == 0:
        print("未找到任何 SARIF 文件。")
        return

    print(f"找到 {total} 个 SARIF 文件，使用 {MAX_WORKERS} 线程并发转换...")

    with ThreadPoolExecutor(max_workers=MAX_WORKERS) as executor:
        future_to_file = {
            executor.submit(parse_sarif, sarif): sarif for sarif, _ in tasks
        }
        processed = 0
        for future in as_completed(future_to_file):
            sarif = future_to_file[future]
            processed += 1
            try:
                result = future.result()
                if result is None:
                    print(f"[{processed}/{total}] {sarif.name} 跳过（CSV 已存在）")
                else:
                    records, path = result
                    for rec in records:
                        rec["model"] = [name for _, name in tasks if _[0] == path][0]  # 获取模型名
                    all_records.extend(records)
                    print(f"[{processed}/{total}] {sarif.name} 完成（{len(records)} 条）")
            except Exception as e:
                print(f"[{processed}/{total}] {sarif.name} 出错: {e}")

    # 生成汇总 CSV
    if all_records:
        with open(SUMMARY_CSV, "w", newline="", encoding="utf-8") as f:
            writer = csv.DictWriter(f, fieldnames=all_records[0].keys())
            writer.writeheader()
            writer.writerows(all_records)
        print(f"汇总报告已生成：{SUMMARY_CSV} (共 {len(all_records)} 条记录)")
    else:
        print("未发现漏洞记录，不生成汇总 CSV。")

if __name__ == "__main__":
    main()