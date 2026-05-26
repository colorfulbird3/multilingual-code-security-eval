#!/usr/bin/env python3
"""
本地推理 Qwen2.5-Coder-1.5B-Instruct（全精度，无需量化）
支持批量生成、独立文件保存、断点续跑
"""
import json
import torch
from pathlib import Path
from transformers import AutoModelForCausalLM, AutoTokenizer

# ================= 配置 =================
MODEL_NAME = "Qwen/Qwen2.5-Coder-1.5B-Instruct"
DATASET_ROOT = Path("./CodeSecBenchHub")
OUTPUT_ROOT = Path("./qwen_output_1.5b_coder")     # 输出目录

BATCH_SIZE = 32               # 8GB 显存可以轻松使用 batch=4
MAX_NEW_TOKENS = 1024
TEMPERATURE = 0.7

LANG_EXT_MAP = {
    "python": (".py", "python"),
    "cpp":    (".cpp", "cpp"),
    "java":   (".java", "java"),
}
# =========================================

def load_model():
    tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME, trust_remote_code=True)
    if tokenizer.pad_token is None:
        tokenizer.pad_token = tokenizer.eos_token
    model = AutoModelForCausalLM.from_pretrained(
        MODEL_NAME,
        device_map="auto",
        torch_dtype=torch.float16,   # 半精度加速
        trust_remote_code=True,
    )
    return tokenizer, model

def load_prompts(lang_dir):
    prompts = []
    seen = set()
    for fpath in sorted(lang_dir.rglob("*")):
        if not fpath.is_file() or fpath.name.startswith("."):
            continue
        if fpath.name.lower() in ("readme.md", "readme", "license", "license.md", ".gitkeep"):
            continue
        name = fpath.name
        if name in seen:
            continue
        seen.add(name)
        try:
            prompt_text = fpath.read_text(encoding="utf-8").strip()
        except:
            continue
        if not prompt_text:
            continue
        prompts.append((name, prompt_text))
    return prompts

def generate_batch(tokenizer, model, prompts):
    texts = []
    for p in prompts:
        messages = [{"role": "user", "content": p}]
        text = tokenizer.apply_chat_template(messages, tokenize=False, add_generation_prompt=True)
        texts.append(text)

    inputs = tokenizer(texts, return_tensors="pt", padding=True, truncation=True, max_length=1024).to(model.device)
    with torch.no_grad():
        outputs = model.generate(
            **inputs,
            max_new_tokens=MAX_NEW_TOKENS,
            temperature=TEMPERATURE,
            do_sample=True,
            pad_token_id=tokenizer.pad_token_id,
        )
    responses = []
    for i, out in enumerate(outputs):
        input_len = len(inputs["input_ids"][i])
        response = tokenizer.decode(out[input_len:], skip_special_tokens=True)
        responses.append(response)
    return responses

def main():
    tokenizer, model = load_model()
    print("模型加载完成，开始批量推理...\n")

    for lang, (ext, dir_name) in LANG_EXT_MAP.items():
        lang_dir = DATASET_ROOT / dir_name
        if not lang_dir.exists():
            continue
        prompts = load_prompts(lang_dir)
        out_dir = OUTPUT_ROOT / lang
        out_dir.mkdir(parents=True, exist_ok=True)

        remaining = [(n, t) for n, t in prompts if not (out_dir / f"{n}.generated{ext}").exists() or (out_dir / f"{n}.generated{ext}").stat().st_size == 0]
        if not remaining:
            continue

        total, done = len(prompts), len(prompts) - len(remaining)
        print(f"📂 {lang}: 共 {total} 个提示，已完成 {done}，待生成 {len(remaining)}")

        for i in range(0, len(remaining), BATCH_SIZE):
            batch = remaining[i:i+BATCH_SIZE]
            names = [n for n, _ in batch]
            texts = [t for _, t in batch]
            try:
                responses = generate_batch(tokenizer, model, texts)
            except torch.cuda.OutOfMemoryError:
                print("显存不足，降级为逐个处理...")
                responses = []
                for t in texts:
                    try:
                        resp = generate_batch(tokenizer, model, [t])
                        responses.append(resp[0])
                    except:
                        responses.append("[OOM_ERROR]")
            for n, resp in zip(names, responses):
                (out_dir / f"{n}.generated{ext}").write_text(resp, encoding="utf-8")
            print(f"  [{done + i + len(batch)}/{total}] {', '.join(names)}")

    print("\n✅ 所有推理任务完成！")

if __name__ == "__main__":
    main()