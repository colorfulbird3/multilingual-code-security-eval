import os
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig
from pathlib import Path
from tqdm import tqdm

# ---------- 配置 ----------
MODEL_NAME = "Qwen/Qwen2-7B-Instruct"
DATASET_ROOT = r"E:\sven\CodeSecBenchHub"
OUTPUT_ROOT = r"E:\sven\qwen_output_7b"      # 新输出目录，区分 0.5B 结果
BATCH_SIZE = 2                               # 4-bit 7B，建议 1~2
MAX_NEW_TOKENS = 512
DEVICE = "cuda" if torch.cuda.is_available() else "cpu"

print(f"Using device: {DEVICE}")
if DEVICE == "cuda":
    print(f"GPU: {torch.cuda.get_device_name(0)}")

# ---------- 加载模型 (4-bit 量化) ----------
print(f"Loading model: {MODEL_NAME}")
tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
tokenizer.padding_side = 'left'          # 解码器模型必须左填充

# 4-bit 量化配置
quantization_config = BitsAndBytesConfig(
    load_in_4bit=True,
    bnb_4bit_compute_dtype=torch.float16,
    bnb_4bit_use_double_quant=True,
    bnb_4bit_quant_type="nf4"
)

model = AutoModelForCausalLM.from_pretrained(
    MODEL_NAME,
    quantization_config=quantization_config,
    device_map="auto",
    torch_dtype=torch.float16
)

if tokenizer.pad_token is None:
    tokenizer.pad_token = tokenizer.eos_token

# ---------- 读取提示词 ----------
def load_prompts(lang_dir):
    prompts = []
    p = Path(DATASET_ROOT) / lang_dir / "prompts"
    if not p.exists():
        print(f"[!] {p} not found, skip")
        return prompts
    for f in p.rglob("*"):
        if f.is_file():
            try:
                txt = f.read_text(encoding="utf-8").strip()
                if txt:
                    prompts.append((f.name, txt))
            except Exception as e:
                print(f"Error reading {f}: {e}")
    return prompts

# ---------- 批量推理 ----------
def generate_batch(prompts_list):
    texts = []
    for _, prompt in prompts_list:
        messages = [{"role": "user", "content": prompt}]
        text = tokenizer.apply_chat_template(
            messages, tokenize=False, add_generation_prompt=True
        )
        texts.append(text)

    inputs = tokenizer(texts, return_tensors="pt", padding=True, truncation=True).to(DEVICE)

    with torch.no_grad():
        outputs = model.generate(
            **inputs,
            max_new_tokens=MAX_NEW_TOKENS,
            pad_token_id=tokenizer.pad_token_id,
            do_sample=True,
            temperature=0.2,            # 低温度，提高稳定性
            top_p=0.95,
            repetition_penalty=1.05,
            use_cache=True
        )
    gen = tokenizer.batch_decode(outputs[:, inputs.input_ids.shape[1]:], skip_special_tokens=True)
    return gen

# ---------- 主循环 ----------
lang_map = {"python": "python", "cpp": "cpp", "java": "java"}
for lang, dir_name in lang_map.items():
    print(f"\n=== Processing {lang} ===")
    prompts = load_prompts(dir_name)
    if not prompts:
        continue
    out_dir = Path(OUTPUT_ROOT) / lang
    out_dir.mkdir(parents=True, exist_ok=True)

    all_code = []
    for i in tqdm(range(0, len(prompts), BATCH_SIZE)):
        batch = prompts[i:i+BATCH_SIZE]
        codes = generate_batch(batch)
        for (fname, _), c in zip(batch, codes):
            all_code.append(f"# Prompt: {fname}\n{c}\n")

    ext = "py" if lang == "python" else lang
    out_file = out_dir / f"generated.{ext}"
    out_file.write_text("\n---END---\n".join(all_code), encoding="utf-8")
    print(f"Saved to {out_file}")

print("\nAll done! Output folder:", OUTPUT_ROOT)