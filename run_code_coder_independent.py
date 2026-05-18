import os
import torch
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig
from pathlib import Path
from tqdm import tqdm

# ==================== 配置 ====================
MODEL_NAME = "Qwen/Qwen2.5-Coder-7B-Instruct"
DATASET_ROOT = r"/home/featurize/sven/multilingual-code-security-eval/CodeSecBenchHub"
OUTPUT_ROOT = r"/home/featurize/sven/multilingual-code-security-eval/qwen_output_coder_independent"
BATCH_SIZE = 24           # 根据显存调整，4090 可用 2~4
MAX_NEW_TOKENS = 512
DEVICE = "cuda" if torch.cuda.is_available() else "cpu"
# ================================================

print(f"Using device: {DEVICE}")
if DEVICE == "cuda":
    print(f"GPU: {torch.cuda.get_device_name(0)}")

# ---------- 加载模型 ----------
print(f"Loading model: {MODEL_NAME}")
tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)
tokenizer.padding_side = "left"

quantization_config = BitsAndBytesConfig(
    load_in_4bit=True,
    bnb_4bit_compute_dtype=torch.float16,
    bnb_4bit_use_double_quant=True,
    bnb_4bit_quant_type="nf4",
)

model = AutoModelForCausalLM.from_pretrained(
    MODEL_NAME,
    quantization_config=quantization_config,
    device_map="auto",
    torch_dtype=torch.float16,
)
if tokenizer.pad_token is None:
    tokenizer.pad_token = tokenizer.eos_token

# ---------- 读取提示词 ----------
def load_prompts(lang_dir):
    """返回 (原始文件名, 提示文本) 列表"""
    prompts = []
    p = Path(DATASET_ROOT) / lang_dir
    if not p.exists():
        print(f"[!] 目录不存在: {p}，跳过")
        return prompts
    # 递归查找所有文件
    for f in sorted(p.rglob("*")):
        if f.is_file():
            try:
                txt = f.read_text(encoding="utf-8").strip()
                if txt:
                    prompts.append((f.name, txt))
            except Exception as e:
                print(f"读取文件 {f} 出错: {e}")
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
            use_cache=True,
        )
    gen = tokenizer.batch_decode(outputs[:, inputs.input_ids.shape[1]:], skip_special_tokens=True)
    return gen

# ---------- 主循环（独立文件输出，支持断点续跑）----------
lang_map = {"python": "python", "cpp": "cpp", "java": "java"}

for lang, dir_name in lang_map.items():
    print(f"\n=== Processing {lang} ===")
    prompts = load_prompts(dir_name)
    if not prompts:
        continue

    out_dir = Path(OUTPUT_ROOT) / lang
    out_dir.mkdir(parents=True, exist_ok=True)

    ext = "py" if lang == "python" else lang  # 文件扩展名

    # ---- 断点续跑：统计已完成的文件 ----
    existing_count = 0
    for fname, _ in prompts:
        out_file = out_dir / f"{fname}.generated.{ext}"
        if out_file.exists() and out_file.stat().st_size > 0:
            existing_count += 1
        else:
            break
    print(f"已存在 {existing_count}/{len(prompts)} 个文件，从第 {existing_count+1} 个开始生成。")

    remaining = prompts[existing_count:]
    if not remaining:
        print(f"{lang} 已全部完成，跳过。")
        continue

    # ---- 分批推理 ----
    for i in tqdm(range(0, len(remaining), BATCH_SIZE)):
        batch = remaining[i:i+BATCH_SIZE]
        codes = generate_batch(batch)
        for (fname, _), code in zip(batch, codes):
            out_file = out_dir / f"{fname}.generated.{ext}"
            out_file.write_text(code, encoding="utf-8")

print("\n✅ 全部完成！输出目录：", OUTPUT_ROOT)