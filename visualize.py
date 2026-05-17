import json
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from pathlib import Path

def parse_sarif(sarif_path):
    """从 SARIF 文件中提取漏洞信息"""
    with open(sarif_path, 'r', encoding='utf-8') as f:
        data = json.load(f)
    
    records = []
    for run in data.get('runs', []):
        tool_name = run.get('tool', {}).get('driver', {}).get('name', 'Unknown')
        for result in run.get('results', []):
            rule_id = result.get('ruleId', 'None')
            # 提取规则编号，比如 "CWE-078" 或者直接用 ruleId
            cwe_tag = rule_id.split('/')[-1] if '/' in rule_id else rule_id
            
            # 提取物理位置，判断是哪个文件
            locations = result.get('locations', [])
            file_path = ""
            if locations:
                file_path = locations[0].get('physicalLocation', {}).get('artifactLocation', {}).get('uri', 'Unknown')
            
            records.append({
                'Tool': tool_name,
                'Rule': cwe_tag,
                'Message': result.get('message', {}).get('text', ''),
                'File': file_path
            })
    
    return pd.DataFrame(records)

# 读取你的三份报告
base_dir = Path(r"E:\sven\qwen_output_7b")
reports = {
    "Python": base_dir / "python-results.sarif",
    "C++": base_dir / "cpp-results.sarif",
    "Java": base_dir / "java-results.sarif"
}

all_data = []
for lang, path in reports.items():
    if path.exists():
        df = parse_sarif(path)
        df['Language'] = lang
        all_data.append(df)
        print(f"✅ {lang}: 发现 {len(df)} 个漏洞。")
    else:
        print(f"❌ 未找到报告: {path}")

if not all_data:
    print("没有找到任何报告文件，无法生成热力图。")
    exit()

# 合并所有数据
df_all = pd.concat(all_data, ignore_index=True)

# 如果数据为空，生成空热力图并标注
if df_all.empty:
    print("所有报告均无漏洞发现，将生成空热力图以展示'致盲效应'。")
    # 手动构建一个全零数据框
    heatmap_data = pd.DataFrame(0, index=["Python", "C++", "Java"], columns=["No vulnerabilities found"])
else:
    # 统计每个语言下每种漏洞的数量
    heatmap_data = df_all.groupby(['Language', 'Rule']).size().unstack(fill_value=0)

# 绘制热力图
plt.figure(figsize=(14, max(4, len(heatmap_data))))
sns.heatmap(heatmap_data, annot=True, fmt="d", cmap="YlOrRd", linewidths=.5)
plt.title('7B Model: Vulnerability Density Heatmap (CodeQL Results)')
plt.ylabel('Programming Language')
plt.xlabel('CWE / Security Rule')
plt.tight_layout()
plt.savefig('vulnerability_heatmap.png', dpi=300)
plt.show()
print("✅ 热力图已保存为 vulnerability_heatmap.png")