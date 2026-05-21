#!/usr/bin/env python3
import os, torch
from pathlib import Path
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig

MODEL_NAME = "Salesforce/codegen-6B-multi"   # 服务器上可直接从 HuggingFace 下载
DATASET_ROOT = Path("./CodeSecBenchHub")
OUTPUT_ROOT =Path("./E:\multilingual-code-security-eval\codegen_output_6bb")
BATCH_SIZE = 4               # 4090 24GB 可用 4
MAX_NEW_TOKENS = 512
TEMPERATURE = 0.7
MAX_TOTAL_LENGTH = 2048       # CodeGen 最大位置编码
MAX_INPUT_LENGTH = MAX_TOTAL_LENGTH - MAX_NEW_TOKENS  # 约1536

LANG_EXT_MAP = {
    "python": (".py", "python"),
    "cpp":    (".cpp", "cpp"),
    "java":   (".java", "java"),
}

def load_model_and_tokenizer():
    print("正在加载 CodeGen-6B 模型（4-bit 量化）...")
    quant_config = BitsAndBytesConfig(
        load_in_4bit=True,
        bnb_4bit_compute_dtype=torch.float16,
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
        torch_dtype=torch.float16,
        ignore_mismatched_sizes=True,
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
            prompt_text = fpath.read_text(encoding="utf-8")
        except:
            continue
        prompts.append((name, prompt_text))
    return prompts

def generate_batch(tokenizer, model, prompts_texts):
    prompts_texts = [p for p in prompts_texts if p and p.strip()]
    if not prompts_texts:
        return []
    input_ids_list = []
    valid_indices = []
    for idx, p in enumerate(prompts_texts):
        inp = tokenizer(p, return_tensors="pt", truncation=True, max_length=MAX_INPUT_LENGTH, padding=False)
        ids = inp["input_ids"][0]
        if ids.size(0) == 0:          # 分词后为空，补一个 eos token
            ids = torch.tensor([tokenizer.eos_token_id])
        input_ids_list.append(ids)
        valid_indices.append(idx)
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


def main():
    if "HF_ENDPOINT" not in os.environ:
        os.environ["HF_ENDPOINT"] = "https://hf-mirror.com"
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
        remaining = [(n,t) for n,t in prompts if not (out_dir/f"{n}.generated{ext}").exists() or (out_dir/f"{n}.generated{ext}").stat().st_size == 0]
        if not remaining:
            continue
        total, done = len(prompts), len(prompts)-len(remaining)
        print(f"📂 {lang}: 共 {total} 个提示，已完成 {done}，待生成 {len(remaining)}")
        for i in range(0, len(remaining), BATCH_SIZE):
            batch = remaining[i:i+BATCH_SIZE]
            names = [n for n,_ in batch]
            texts = [t for _,t in batch]
            try:
                responses = generate_batch(tokenizer, model, texts)
            except torch.cuda.OutOfMemoryError:
                print("显存不足，降级为逐个处理...")
                responses = []
                for n,t in batch:
                    try:
                        responses.append(generate_batch(tokenizer, model, [t])[0])
                    except:
                        responses.append("[OOM_ERROR]")
            for n, r in zip(names, responses):
                (out_dir/f"{n}.generated{ext}").write_text(r, encoding="utf-8")
            print(f"  [{done+i+len(batch)}/{total}] {', '.join(names)}")
    print("\n✅ 所有推理任务完成！")

if __name__ == "__main__":
    main()