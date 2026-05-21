#!/usr/bin/env python3
import json, os, torch
from pathlib import Path
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig

MODEL_NAME = "Qwen/Qwen2.5-Coder-14B-Instruct"
DATASET_ROOT = Path("./CodeSecBenchHub")
OUTPUT_ROOT = Path("./qwen_output_coder_14b")
BATCH_SIZE = 4
MAX_NEW_TOKENS = 2048
TEMPERATURE = 0.7

# 注意：目录名全部小写，与你的服务器一致
LANG_EXT_MAP = {
    "python": (".py", "python"),
    "cpp":    (".cpp", "cpp"),
    "java":   (".java", "java"),
}

def load_model_and_tokenizer():
    print("正在加载模型（4-bit 量化）...")
    quant_config = BitsAndBytesConfig(
        load_in_4bit=True,
        bnb_4bit_compute_dtype=torch.float16,
        bnb_4bit_use_double_quant=True,
    )
    tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
    if tokenizer.pad_token is None:
        tokenizer.pad_token = tokenizer.eos_token
    # 强制左填充，消除 right-padding 警告
    tokenizer.padding_side = "left"
    model = AutoModelForCausalLM.from_pretrained(
        MODEL_NAME,
        quantization_config=quant_config,
        device_map="auto",
        torch_dtype=torch.float16,
    )
    return tokenizer, model

def load_prompts(lang_dir):
    """从 CodeSecBenchHub 目录读取提示（文件带有 .af/.tl/.zu 等后缀）"""
    prompts = []
    seen = set()
    for fpath in sorted(lang_dir.rglob("*")):
        if not fpath.is_file():
            continue
        # 跳过隐藏文件
        if fpath.name.startswith("."):
            continue
        # 跳过已知的非提示文件（如 README.md, LICENSE）
        if fpath.name.lower() in ("readme.md", "readme", "license", "license.md", ".gitkeep"):
            continue
        # 使用完整文件名（如 CodeInjectionEval.af）作为标识，保留语言后缀
        name = fpath.name          # 例如 "CodeInjectionEval.af"
        if name in seen:
            continue
        seen.add(name)
        try:
            prompt_text = fpath.read_text(encoding="utf-8")
        except Exception:
            continue
        prompts.append((name, prompt_text))
    return prompts

def generate_batch(tokenizer, model, prompts_texts):
    texts = []
    for prompt in prompts_texts:
        messages = [{"role": "user", "content": prompt}]
        text = tokenizer.apply_chat_template(messages, tokenize=False, add_generation_prompt=True)
        texts.append(text)
    inputs = tokenizer(texts, return_tensors="pt", padding=True, truncation=True, max_length=2048).to(model.device)
    with torch.no_grad():
        outputs = model.generate(**inputs, max_new_tokens=MAX_NEW_TOKENS, temperature=TEMPERATURE, do_sample=True, pad_token_id=tokenizer.pad_token_id)
    responses = []
    for i, output in enumerate(outputs):
        input_len = len(inputs["input_ids"][i])
        response = tokenizer.decode(output[input_len:], skip_special_tokens=True)
        responses.append(response)
    return responses

def main():
    if "HF_ENDPOINT" not in os.environ:
        os.environ["HF_ENDPOINT"] = "https://hf-mirror.com"
    tokenizer, model = load_model_and_tokenizer()
    print(f"模型加载完成，开始批量推理（BATCH_SIZE={BATCH_SIZE}）...\n")
    for lang, (ext, dir_name) in LANG_EXT_MAP.items():
        lang_dir = DATASET_ROOT / dir_name
        if not lang_dir.exists():
            print(f"⚠ 跳过不存在的目录：{lang_dir}")
            continue
        prompts = load_prompts(lang_dir)
        if not prompts:
            print(f"⚠ 语言 {lang} 下没有找到提示文件，跳过。")
            continue
        out_dir = OUTPUT_ROOT / lang
        out_dir.mkdir(parents=True, exist_ok=True)
        remaining = []
        for fname, text in prompts:
            out_file = out_dir / f"{fname}.generated{ext}"
            if out_file.exists() and out_file.stat().st_size > 0:
                continue
            remaining.append((fname, text))
        if not remaining:
            print(f"✅ {lang}: 所有文件均已生成，跳过。")
            continue
        total = len(prompts)
        done = total - len(remaining)
        print(f"📂 {lang}: 共 {total} 个提示，已完成 {done}，待生成 {len(remaining)}。")
        for i in range(0, len(remaining), BATCH_SIZE):
            batch = remaining[i:i+BATCH_SIZE]
            batch_names = [n for n, _ in batch]
            batch_texts = [t for _, t in batch]
            try:
                responses = generate_batch(tokenizer, model, batch_texts)
            except torch.cuda.OutOfMemoryError:
                print("显存不足，降级为逐个处理...")
                responses = []
                for text in batch_texts:
                    try:
                        res = generate_batch(tokenizer, model, [text])
                        responses.append(res[0])
                    except Exception:
                        responses.append("[OOM_ERROR]")
            for name, resp in zip(batch_names, responses):
                out_file = out_dir / f"{name}.generated{ext}"
                out_file.write_text(resp, encoding="utf-8")
            # 修正进度显示：使用 done + i + len(batch)
            print(f"  [{done + i + len(batch)}/{total}] {', '.join(batch_names)}")
    print("\n✅ 所有推理任务完成！")

if __name__ == "__main__":
    main()