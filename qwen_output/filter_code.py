import ast
from pathlib import Path

input_file = Path(r"E:\sven\qwen_output\python\generated.py")
output_file = Path(r"E:\sven\qwen_output\python\generated_clean.py")

raw = input_file.read_text(encoding="utf-8")
samples = raw.split("---END---")

valid_samples = []
for i, sample in enumerate(samples):
    sample = sample.strip()
    if not sample:
        continue
    try:
        ast.parse(sample)
        valid_samples.append(sample)
    except SyntaxError:
        print(f"✗ 片段 {i+1}/{len(samples)} 语法错误，已跳过")

if valid_samples:
    clean_content = "\n\n# ---END---\n\n".join(valid_samples)
    output_file.write_text(clean_content, encoding="utf-8")
    print(f"\n✓ 完成！从 {len(samples)} 个片段中保留了 {len(valid_samples)} 个有效片段。")
    print(f"  干净代码已保存至: {output_file}")
else:
    print("\n✗ 未发现任何语法正确的代码片段。")