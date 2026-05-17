import os
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig
from pathlib import Path
from tqdm import tqdm

# ---------- 配置 ----------
MODEL_NAME = "Qwen/Qwen2-7B-Instruct"
DATASET_ROOT = r"E:\sven\CodeSecBenchHub"
OUTPUT_ROOT = r"E:\sven\qwen_output_7b"
BATCH_SIZE = 1
MAX_NEW_TOKENS = 256
DEVICE = "cuda" if torch.cuda.is_available() else "cpu"

print(f"Using device: {DEVICE}")
if DEVICE == "cuda":
    print(f"GPU: {torch.cuda.get_device_name(0)}")

# ---------- 加载模型 ----------
print(f"Loading model: {MODEL_NAME}")
tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
tokenizer.padding_side = 'left'

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
    # 按文件名排序，确保顺序一致
    files = sorted(p.rglob("*"))
    for f in files:
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
            temperature=0.2,
            top_p=0.95,
            repetition_penalty=1.05,
            use_cache=True
        )
    gen = tokenizer.batch_decode(outputs[:, inputs.input_ids.shape[1]:], skip_special_tokens=True)
    return gen

# ---------- 断点续跑核心函数 ----------
def count_existing_samples(output_file):
    """统计输出文件中已完成的片段数"""
    if not output_file.exists():
        return 0
    content = output_file.read_text(encoding="utf-8")
    # 按分隔符分割，计算片段数
    parts = content.split("---END---")
    # 最后一个片段可能不完整，只统计完整分隔符前的片段
    return len(parts) - 1

# ---------- 主循环（支持断点续跑）----------
lang_map = {"python": "python", "cpp": "cpp", "java": "java"}
for lang, dir_name in lang_map.items():
    print(f"\n=== Processing {lang} ===")
    prompts = load_prompts(dir_name)
    if not prompts:
        continue

    out_dir = Path(OUTPUT_ROOT) / lang
    out_dir.mkdir(parents=True, exist_ok=True)
    ext = "py" if lang == "python" else lang
    out_file = out_dir / f"generated.{ext}"

    # 统计已完成的片段数
    done = count_existing_samples(out_file)
    total = len(prompts)
    print(f"Found {done}/{total} already processed. Resuming from sample {done+1}.")

    # 如果已完成所有，跳过
    if done >= total:
        print(f"All prompts for {lang} already done. Skipping.")
        continue

    # 跳过已处理的提示词
    remaining_prompts = prompts[done:]

    # 如果文件已存在，以追加模式打开；否则新建
    mode = "a" if out_file.exists() else "w"
    with open(out_file, mode, encoding="utf-8") as f:
        # 如果是新建文件，无需写文件头
        for i in tqdm(range(0, len(remaining_prompts), BATCH_SIZE), initial=0, total=len(remaining_prompts)//BATCH_SIZE+1):
            batch = remaining_prompts[i:i+BATCH_SIZE]
            codes = generate_batch(batch)
            for (fname, _), c in zip(batch, codes):
                f.write(f"# Prompt: {fname}\n{c}\n")
                f.write("---END---\n")
            f.flush()  # 及时写入磁盘，避免中断丢失数据

    print(f"Saved updates to {out_file}")

print("\nAll done! Output folder:", OUTPUT_ROOT)