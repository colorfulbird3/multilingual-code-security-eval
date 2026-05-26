import re
import getpass
from pathlib import Path
from concurrent.futures import ThreadPoolExecutor, as_completed
from openai import OpenAI

# ========== 配置 ==========
API_BASE = "https://api.deepseek.com"
MODEL = "deepseek-chat"
MAX_WORKERS = 10          # 并发线程数
RETRY_COUNT = 2          # 失败重试次数

# 要处理的模型目录
INPUT_DIRS = [
    #"qwen_output_coder_7b",
    #"qwen_output_coder_14b",
    #"codegen_output_16b",
    #"qwen_output_0.5b",        
    #"codegen_output_6b",
    #"qwen_output_1.5b_coder",
    "qwen_output_codegen_2b",
]

OUTPUT_PREFIX = "extracted_"

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
    cdata = CDATA_PATTERN.findall(raw_text)
    if cdata:
        return max(cdata, key=len).strip()
    md = MARKDOWN_CODE_PATTERN.findall(raw_text)
    if md:
        return max(md, key=len).strip()
    return raw_text


def deepseek_refine(client, text):
    for attempt in range(RETRY_COUNT + 1):
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
            if attempt < RETRY_COUNT:
                print(f"  ↳ API error (retry {attempt+1}/{RETRY_COUNT}): {e}")
            else:
                print(f"  ↳ API error after retries: {e}, using original text")
                return text


def process_single_file(client, lang, file_path, out_root):
    """处理单个文件，返回状态信息（成功/跳过/失败）"""
    raw_content = file_path.read_text(encoding="utf-8")
    if len(raw_content) < 20:
        return "skipped"

    pre_code = pre_extract(raw_content)

    if len(pre_code) > 0 and "<![CDATA[" not in pre_code and "```" not in pre_code and not re.search(r'<\w+>', pre_code):
        if is_valid_code(pre_code, lang):
            clean_code = pre_code
            api_used = False
        else:
            clean_code = deepseek_refine(client, pre_code)
            api_used = True
    else:
        clean_code = deepseek_refine(client, raw_content)
        api_used = True

    valid = is_valid_code(clean_code, lang)
    subdir = "valid" if valid else "invalid"
    out_dir = out_root / subdir / lang
    out_dir.mkdir(parents=True, exist_ok=True)
    out_file = out_dir / file_path.name
    out_file.write_text(clean_code, encoding="utf-8")

    return {
        "file": file_path.name,
        "valid": valid,
        "api_used": api_used,
    }


def process_directory(client, input_dir, output_base):
    in_path = Path(input_dir)
    if not in_path.exists():
        print(f"❌ 目录不存在：{input_dir}，跳过")
        return

    out_root = Path(output_base)
    print(f"\n{'='*60}")
    print(f"📂 处理目录：{input_dir} → {output_base}")
    print(f"{'='*60}")

    # 收集所有文件，并过滤掉已成功提取的
    all_files = []
    skipped_already = 0
    for lang_dir in in_path.iterdir():
        if not lang_dir.is_dir():
            continue
        for file_path in lang_dir.glob("*.generated.*"):
            lang = lang_dir.name
            # 断点续跑核心逻辑：检查输出文件是否已存在（valid 或 invalid 目录下）
            out_valid = out_root / "valid" / lang / file_path.name
            out_invalid = out_root / "invalid" / lang / file_path.name
            if out_valid.exists() or out_invalid.exists():
                # 文件已存在，跳过（无论之前是 valid 还是 invalid，都不重复处理）
                skipped_already += 1
                continue
            all_files.append((lang, file_path))

    total_new = len(all_files)
    print(f"Total files: {skipped_already + total_new}, already processed: {skipped_already}, to process: {total_new}")

    if total_new == 0:
        print("所有文件均已处理，无需工作。")
        return

    # 并发处理新文件
    skipped = 0
    valid_count = 0
    invalid_count = 0
    api_calls = 0
    processed = 0

    with ThreadPoolExecutor(max_workers=MAX_WORKERS) as executor:
        future_to_file = {
            executor.submit(process_single_file, client, lang, file_path, out_root): file_path
            for lang, file_path in all_files
        }

        for future in as_completed(future_to_file):
            processed += 1
            file = future_to_file[future]
            try:
                result = future.result()
                if result == "skipped":
                    skipped += 1
                    print(f"[{processed}/{total_new}] {file.name} skipped (too short)")
                else:
                    if result["valid"]:
                        valid_count += 1
                        tag = "Valid"
                    else:
                        invalid_count += 1
                        tag = "Invalid"
                    if result["api_used"]:
                        api_calls += 1
                    print(f"[{processed}/{total_new}] {file.name} -> {tag}")
            except Exception as e:
                print(f"[{processed}/{total_new}] {file.name} ERROR: {e}")

    print(f"\n--- {input_dir} 本次完成 ---")
    print(f"Newly processed: {total_new}")
    print(f"Skipped (too short): {skipped}")
    print(f"Valid code files: {valid_count}")
    print(f"Invalid code files: {invalid_count}")
    print(f"API calls made: {api_calls}")


def main():
    api_key = getpass.getpass("Enter your DeepSeek API Key: ")
    client = OpenAI(api_key=api_key, base_url=API_BASE)

    for input_dir in INPUT_DIRS:
        output_dir = OUTPUT_PREFIX + input_dir
        process_directory(client, input_dir, output_dir)

    print("\n🎉 所有目录处理完毕！")


if __name__ == "__main__":
    main()