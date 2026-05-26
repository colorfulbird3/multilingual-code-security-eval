#!/usr/bin/env python3
"""
CodeGen-2B-multi (4‑bit 量化 + 半精度) 批量推理脚本
适用于 24GB 显存服务器，BATCH_SIZE=8 安全，支持断点续跑
"""
import os
import torch
from pathlib import Path
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig

# ==================== 配置 ====================
MODEL_NAME = "Salesforce/codegen-2B-multi"
DATASET_ROOT = Path("./CodeSecBenchHub")
OUTPUT_ROOT = Path("./qwen_output_codegen_2b")

BATCH_SIZE = 8                # 4‑bit 量化后 24GB 可安全使用 8～12
MAX_NEW_TOKENS = 1024
TEMPERATURE = 0.7
MAX_TOTAL_LENGTH = 2048       # CodeGen 最大位置编码
MAX_INPUT_LENGTH = MAX_TOTAL_LENGTH - MAX_NEW_TOKENS   # 约 1024

LANG_EXT_MAP = {
    "python": (".py", "python"),
    "cpp":    (".cpp", "cpp"),
    "java":   (".java", "java"),
}
# ===============================================


def load_model_and_tokenizer():
    print("正在加载 CodeGen-2B 模型（4‑bit 量化 + 半精度）...")
    quant_config = BitsAndBytesConfig(
        load_in_4bit=True,
        bnb_4bit_compute_dtype=torch.float16,   # 半精度计算
        bnb_4bit_use_double_quant=True,
    )
    tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
    if tokenizer.pad_token is None:
        tokenizer.pad_token = tokenizer.eos_token
    tokenizer.padding_side = "left"

    model = AutoModelForCausalLM.from_pretrained(
        MODEL_NAME,
        quantization_config=quant_config,
        device_map="auto",
        torch_dtype=torch.float16,   # 确保内部计算使用半精度
        ignore_mismatched_sizes=True,
    )
    return tokenizer, model


def load_prompts(lang_dir: Path):
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


def format_prompt_for_codegen(raw_prompt: str, lang: str) -> str:
    comment_map = {"python": "# ", "cpp": "// ", "java": "// "}
    prefix = comment_map.get(lang, "// ")
    lines = raw_prompt.splitlines()
    commented = "\n".join(prefix + line.strip() for line in lines if line.strip())
    return commented + "\n"


def generate_batch(tokenizer, model, prompts_texts, lang):
    formatted = [format_prompt_for_codegen(p, lang) for p in prompts_texts]
    input_ids_list = []
    for p in formatted:
        inp = tokenizer(p, return_tensors="pt", truncation=True,
                        max_length=MAX_INPUT_LENGTH, padding=False)
        input_ids_list.append(inp["input_ids"][0])

    max_len = max(t.size(0) for t in input_ids_list)
    padded = torch.full((len(input_ids_list), max_len), tokenizer.pad_token_id, dtype=torch.long)
    for i, ids in enumerate(input_ids_list):
        padded[i, -len(ids):] = ids

    inputs = {
        "input_ids": padded.to(model.device),
        "attention_mask": (padded != tokenizer.pad_token_id).long().to(model.device),
    }

    with torch.no_grad():
        outputs = model.generate(
            **inputs,
            max_new_tokens=MAX_NEW_TOKENS,
            temperature=TEMPERATURE,
            do_sample=True,
            pad_token_id=tokenizer.eos_token_id,
            eos_token_id=tokenizer.eos_token_id,
        )

    responses = []
    for i, output in enumerate(outputs):
        input_len = len(input_ids_list[i])
        responses.append(tokenizer.decode(output[input_len:], skip_special_tokens=True))
    return responses


def generate_single(tokenizer, model, prompt_text, lang):
    formatted = format_prompt_for_codegen(prompt_text, lang)
    inputs = tokenizer(formatted, return_tensors="pt", truncation=True,
                       max_length=MAX_INPUT_LENGTH, padding=False).to(model.device)
    with torch.no_grad():
        outputs = model.generate(
            **inputs,
            max_new_tokens=MAX_NEW_TOKENS,
            temperature=TEMPERATURE,
            do_sample=True,
            pad_token_id=tokenizer.eos_token_id,
            eos_token_id=tokenizer.eos_token_id,
        )
    return tokenizer.decode(outputs[0][inputs.input_ids.shape[1]:], skip_special_tokens=True)


def main():
    tokenizer, model = load_model_and_tokenizer()
    print(f"模型加载完成，开始批量推理（BATCH_SIZE={BATCH_SIZE}）...\n")

    for lang, (ext, dir_name) in LANG_EXT_MAP.items():
        lang_dir = DATASET_ROOT / dir_name
        if not lang_dir.exists():
            continue

        prompts = load_prompts(lang_dir)
        if not prompts:
            continue

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
                responses = generate_batch(tokenizer, model, texts, lang)
            except torch.cuda.OutOfMemoryError:
                print("显存不足，降级为逐个处理...")
                responses = []
                for name, text in batch:
                    try:
                        responses.append(generate_single(tokenizer, model, text, lang))
                    except:
                        responses.append("[OOM_ERROR]")
            except Exception as e:
                print(f"批量生成出错：{e}，降级为逐个处理...")
                responses = []
                for name, text in batch:
                    try:
                        responses.append(generate_single(tokenizer, model, text, lang))
                    except:
                        responses.append("[ERROR]")

            for name, resp in zip(names, responses):
                (out_dir / f"{name}.generated{ext}").write_text(resp, encoding="utf-8")

            print(f"  [{done + i + len(batch)}/{total}] {', '.join(names)}")

    print("\n✅ 所有推理任务完成！")


if __name__ == "__main__":
    main()