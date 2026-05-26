import json
import yaml
from pathlib import Path

# 1. 加载漏洞 schema
schema_path = Path('datasets/static/vulnerability_schema.yaml')
with open(schema_path, 'r', encoding='utf-8') as f:
    schema = yaml.safe_load(f)

# 2. 加载 Java 测试用例，提取所有 regex
benchmark_path = Path('datasets/benchmark/java/java.json')
with open(benchmark_path, 'r', encoding='utf-8') as f:
    benchmark = json.load(f)

# 收集每个 CWE 的所有正则表达式
cwe_regex = {}
for entry in benchmark['benchmark']:
    cwe = entry.get('cwe', 'Unknown')
    check = entry.get('check', {})
    regex_list = check.get('regex', [])
    if regex_list:
        cwe_regex.setdefault(cwe, set())
        for r in regex_list:
            cwe_regex[cwe].add(r)

# 3. 整理输出
output = {}
for cwe, regex_set in sorted(cwe_regex.items()):
    cwe_info = schema.get(cwe, {})
    output[cwe] = {
        'title': cwe_info.get('title', ''),
        'description': cwe_info.get('description', ''),
        'severity': cwe_info.get('severity', 'Medium'),
        'regex_patterns': sorted(list(regex_set))
    }

# 保存为 JSON 文件
with open('extracted_regex_rules.json', 'w', encoding='utf-8') as f:
    json.dump(output, f, indent=2, ensure_ascii=False)

print(f'提取完成，共 {len(output)} 个 CWE 类别')