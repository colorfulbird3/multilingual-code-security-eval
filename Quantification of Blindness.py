import json
from pathlib import Path

reports = [
    "python-results.sarif",
    "cpp-results.sarif",
    "java-results.sarif"
]
base = Path("E:/sven/qwen_output_7b")

for r in reports:
    path = base / r
    if path.exists():
        with open(path, 'r') as f:
            data = json.load(f)
        for run in data.get('runs', []):
            # 提取诊断信息
            diags = run.get('invocations', [{}])[0].get('toolExecutionNotifications', [])
            print(f"{r}: {len(diags)} diagnostics")
            for d in diags[:3]:  # 只看前3条
                print(f"  - {d.get('message', {}).get('text', '')}")