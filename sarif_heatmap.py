import json
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from pathlib import Path

# 配置
RESULTS_DIR = Path("extracted_code/results")
OUTPUT_PNG = "vulnerability_heatmap.png"

LANGUAGES = ["python", "cpp", "java"]
CATEGORIES = ["valid", "invalid"]

def count_vulnerabilities(sarif_path):
    """从SARIF文件中提取漏洞总数（results中的rules计数）"""
    with open(sarif_path, 'r', encoding='utf-8') as f:
        data = json.load(f)
    count = 0
    for run in data.get("runs", []):
        count += len(run.get("results", []))
    return count

def main():
    data = {"Category": [], "Language": [], "Vulnerabilities": []}
    
    for cat in CATEGORIES:
        for lang in LANGUAGES:
            file_name = f"{cat}-{lang}-results.sarif"
            file_path = RESULTS_DIR / file_name
            if file_path.exists():
                vuln_count = count_vulnerabilities(file_path)
            else:
                vuln_count = 0  # 文件不存在则视为0
            data["Category"].append(cat.capitalize())
            data["Language"].append(lang.capitalize())
            data["Vulnerabilities"].append(vuln_count)

    df = pd.DataFrame(data)
    # 透视成表格形式，行为Category，列为Language
    heatmap_data = df.pivot(index="Category", columns="Language", values="Vulnerabilities")
    
    # 画热力图
    plt.figure(figsize=(8, 4))
    sns.heatmap(heatmap_data, annot=True, fmt="d", cmap="YlOrRd", cbar_kws={'label': 'Vulnerability Count'})
    plt.title("CodeQL Vulnerability Count by Language and Validity")
    plt.tight_layout()
    plt.savefig(OUTPUT_PNG)
    print(f"Heatmap saved to {OUTPUT_PNG}")

if __name__ == "__main__":
    main()