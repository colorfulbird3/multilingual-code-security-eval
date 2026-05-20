import re
import getpass
from pathlib import Path
from openai import OpenAI

# ========== 配置 ==========
API_BASE = "https://api.deepseek.com"
MODEL = "deepseek-chat"

INPUT_ROOT = Path("qwen_output_coder_independent")
OUTPUT_ROOT = Path("extracted_code")   # 主输出目录，内含 valid/ 和 invalid/

SYSTEM_PROMPT = (
    "You are an expert code extractor. You will receive raw LLM output that may contain "
    "Markdown fenced code blocks, XML wrappers, or natural language explanations. "
    "You must return ONLY the final plain source code, with absolutely NO wrappers.\n"
    "Rules:\n"
    "- Remove ALL markdown fences (```), XML tags, CDATA sections, <filename>, <explanation>.\n"
    "- Do NOT add any new comments, explanations, or markdown.\n"
    "- If the input already contains only code, output it unchanged.\n"
    "- If there are multiple code blocks, output the longest one.\n"
    "- If no code is found, output an empty string.\n"
    "Output ONLY the code, without any quotes or backticks."
)

CDATA_PATTERN = re.compile(r'<!\[CDATA\[(.*?)\]\]>', re.DOTALL)
MARKDOWN_CODE_PATTERN = re.compile(r'```(?:\w+)?\s*\n(.*?)```', re.DOTALL)

def is_valid_code(code: str, lang: str) -> bool:
    """检查提取后的代码是否看起来有效"""
    code = code.strip()
    if len(code) < 10:
        return False

    refusal_phrases = [
        "i cannot", "i'm unable", "i am unable", "sorry", "as an ai",
        "i can't", "unable to", "not able to", "however,"
    ]
    lower_code = code.lower()
    for phrase in refusal_phrases:
        if phrase in lower_code:
            return False

    indicators = {
        "python": ["def ", "import ", "print(", "class ", "if __name__", "#"],
        "cpp":    ["#include", "int main", "void ", "std::", "->"],
        "java":   ["public class", "public static void main", "import java", "System.out"]
    }
    if lang in indicators:
        for ind in indicators[lang]:
            if ind in code:
                return True
        return False
    return True

def pre_extract(raw_text: str) -> str:
    cdata_matches = CDATA_PATTERN.findall(raw_text)
    if cdata_matches:
        return max(cdata_matches, key=len).strip()
    md_matches = MARKDOWN_CODE_PATTERN.findall(raw_text)
    if md_matches:
        return max(md_matches, key=len).strip()
    return raw_text

def deepseek_refine(client, text):
    try:
        response = client.chat.completions.create(
            model=MODEL,
            messages=[
                {"role": "system", "content": SYSTEM_PROMPT},
                {"role": "user", "content": text}
            ],
            temperature=0.0,
            max_tokens=4096,
        )
        return response.choices[0].message.content.strip()
    except Exception as e:
        print(f"  ↳ API error: {e}, using original text")
        return text

def main():
    api_key = getpass.getpass("Enter your DeepSeek API Key: ")
    client = OpenAI(api_key=api_key, base_url=API_BASE)

    all_files = []
    for lang_dir in INPUT_ROOT.iterdir():
        if not lang_dir.is_dir():
            continue
        for file_path in lang_dir.glob("*.generated.*"):
            all_files.append((lang_dir.name, file_path))

    total = len(all_files)
    print(f"Total files scanned: {total}")
    processed = 0
    skipped = 0
    valid_count = 0
    invalid_count = 0
    regex_only = 0

    for lang, file_path in all_files:
        processed += 1
        print(f"\n[{processed}/{total}] {file_path}")

        raw_content = file_path.read_text(encoding="utf-8")
        if len(raw_content) < 20:
            print("  ↳ Too short, skipped.")
            skipped += 1
            continue

        # 预处理
        pre_code = pre_extract(raw_content)

        # 判断是否可以直接使用预处理结果
        if len(pre_code) > 0 and "<![CDATA[" not in pre_code and "```" not in pre_code and not re.search(r'<\w+>', pre_code):
            if is_valid_code(pre_code, lang):
                print("  ↳ Pre-extraction valid, skipping API.")
                clean_code = pre_code
                regex_only += 1
            else:
                print("  ↳ Pre-extraction clean but possibly invalid, trying API refinement...")
                clean_code = deepseek_refine(client, pre_code)
        else:
            clean_code = deepseek_refine(client, raw_content)

        # 决定保存到 valid 还是 invalid
        valid = is_valid_code(clean_code, lang)
        subdir = "valid" if valid else "invalid"
        out_dir = OUTPUT_ROOT / subdir / lang
        out_dir.mkdir(parents=True, exist_ok=True)
        out_file = out_dir / file_path.name
        out_file.write_text(clean_code, encoding="utf-8")
        
        if valid:
            valid_count += 1
            print(f"  ↳ Valid -> {out_file}")
        else:
            invalid_count += 1
            print(f"  ↳ Invalid -> {out_file}")

    print(f"\n--- Finished ---")
    print(f"Total scanned: {total}")
    print(f"Skipped (too short): {skipped}")
    print(f"Valid code files: {valid_count}")
    print(f"  - from regex only: {regex_only}")
    print(f"  - from API: {valid_count - regex_only}")
    print(f"Invalid (refusal/junk) files: {invalid_count}")

if __name__ == "__main__":
    main()