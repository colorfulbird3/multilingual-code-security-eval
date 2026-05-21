#!/usr/bin/env python3
"""
批量推理脚本：Salesforce/codegen-16B-multi (4-bit 量化)
针对 CodeSecBenchHub 数据集（纯文本提示文件，无后缀，位于子目录中），
独立保存每个代码文件，支持断点续跑、批量生成。

环境要求：
    pip install transformers==4.31.0
    pip install bitsandbytes==0.43.0
"""
import os
import torch
from pathlib import Path
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig

# ==================== 配置 ====================
MODEL_NAME = "Salesforce/codegen-16B-multi"
DATASET_ROOT = Path("./CodeSecBenchHub")
OUTPUT_ROOT = Path("./codegen_output_16b")   # 输出根目录

BATCH_SIZE = 2                # 批量大小（24GB 显存可尝试 2，如果 OOM 请改为 1）
MAX_NEW_TOKENS = 512          # 单次生成的最大新 token 数
TEMPERATURE = 0.7
MAX_TOTAL_LENGTH = 2048       # CodeGen 最大位置编码
MAX_INPUT_LENGTH = MAX_TOTAL_LENGTH - MAX_NEW_TOKENS  # 输入保留长度（约1536）

# 语言映射：文件夹名 → (扩展名, 数据集目录名)  注意全部小写
LANG_EXT_MAP = {
    "python": (".py", "python"),
    "cpp":    (".cpp", "cpp"),
    "java":   (".java", "java"),
}
# ===============================================


def load_model_and_tokenizer():
    print("正在加载 CodeGen-16B 模型（4-bit 量化）...")
    quant_config = BitsAndBytesConfig(
        load_in_4bit=True,
        bnb_4bit_compute_dtype=torch.float16,
        bnb_4bit_use_double_quant=True,
    )
    tokenizer = AutoTokenizer.from_pretrained(MODEL_NAME)

    # 设置 pad_token，并强制左填充
    if tokenizer.pad_token is None:
        tokenizer.pad_token = tokenizer.eos_token
    tokenizer.padding_side = "left"

    # 加载模型（不使用 safetensors，因为 CodeGen 只有 pytorch_model.bin）
    model = AutoModelForCausalLM.from_pretrained(
        MODEL_NAME,
        quantization_config=quant_config,
        device_map="auto",
        torch_dtype=torch.float16,
        # use_safetensors=True,   # 注释掉，该模型没有 safetensors 文件
        ignore_mismatched_sizes=True,   # 避免形状不匹配警告
    )
    return tokenizer, model


def load_prompts(lang_dir: Path):
    """
    从数据集目录递归读取提示文件。
    数据集结构示例：CodeSecBenchHub/python/prompts/2_1_0/CodeInjectionEval.af
    文件无标准扩展名，但可能带类似 .af/.tl/.zu 的语言后缀。
    跳过目录、隐藏文件、README/LICENSE 等。
    """
    prompts = []
    seen = set()
    for fpath in sorted(lang_dir.rglob("*")):
        if not fpath.is_file():
            continue
        # 跳过隐藏文件
        if fpath.name.startswith("."):
            continue
        # 跳过已知的非提示文件（忽略大小写）
        if fpath.name.lower() in ("readme.md", "readme", "license", "license.md", ".gitkeep"):
            continue

        # 用完整文件名作为标识（例如 "CodeInjectionEval.af"）
        name = fpath.name
        if name in seen:
            continue
        seen.add(name)

        try:
            prompt_text = fpath.read_text(encoding="utf-8")
        except Exception:
            continue  # 无法读取则跳过

        prompts.append((name, prompt_text))
    return prompts


def generate_batch(tokenizer, model, prompts_texts):
    """
    批量生成代码。
    prompts_texts: 列表 [str, str, ...]
    返回: 列表 [generated_code1, generated_code2, ...]
    """
    # 分别截断每个提示，记录原始长度
    input_ids_list = []
    for prompt in prompts_texts:
        inp = tokenizer(
            prompt,
            return_tensors="pt",
            truncation=True,
            max_length=MAX_INPUT_LENGTH,
            padding=False,
        )
        input_ids_list.append(inp["input_ids"][0])

    # 手动填充到相同长度（左填充）
    max_len = max(t.size(0) for t in input_ids_list)
    padded = torch.full((len(input_ids_list), max_len), tokenizer.pad_token_id, dtype=torch.long)
    for i, ids in enumerate(input_ids_list):
        padded[i, -len(ids):] = ids   # 左填充

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
        generated_ids = output[input_len:]
        response = tokenizer.decode(generated_ids, skip_special_tokens=True)
        responses.append(response)
    return responses


def generate_code(tokenizer, model, prompt_text):
    """备用单条生成（当批量出错时使用，也限制长度）"""
    inputs = tokenizer(
        prompt_text,
        return_tensors="pt",
        truncation=True,
        max_length=MAX_INPUT_LENGTH,
        padding=False,
    ).to(model.device)
    with torch.no_grad():
        outputs = model.generate(
            **inputs,
            max_new_tokens=MAX_NEW_TOKENS,
            temperature=TEMPERATURE,
            do_sample=True,
            pad_token_id=tokenizer.eos_token_id,
            eos_token_id=tokenizer.eos_token_id,
        )
    input_len = inputs.input_ids.shape[1]
    return tokenizer.decode(outputs[0][input_len:], skip_special_tokens=True)


def main():
    if "HF_ENDPOINT" not in os.environ:
        os.environ["HF_ENDPOINT"] = "https://hf-mirror.com"
        print("已设置 HF_ENDPOINT 为国内镜像，加速模型下载。")

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

        # 断点续跑：跳过已存在且非空的文件
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

        # 批量处理
        for i in range(0, len(remaining), BATCH_SIZE):
            batch = remaining[i:i+BATCH_SIZE]
            batch_names = [n for n, _ in batch]
            batch_texts = [t for _, t in batch]

            try:
                responses = generate_batch(tokenizer, model, batch_texts)
            except torch.cuda.OutOfMemoryError:
                print("显存不足，降级为逐个处理...")
                responses = []
                for name, text in batch:
                    try:
                        resp = generate_code(tokenizer, model, text)
                        responses.append(resp)
                    except Exception:
                        responses.append("[OOM_ERROR]")
            except Exception as e:
                print(f"批量生成出错：{e}，降级为逐个处理...")
                responses = []
                for name, text in batch:
                    try:
                        resp = generate_code(tokenizer, model, text)
                        responses.append(resp)
                    except Exception:
                        responses.append("[ERROR]")

            # 保存结果
            for name, resp in zip(batch_names, responses):
                out_file = out_dir / f"{name}.generated{ext}"
                out_file.write_text(resp, encoding="utf-8")

            # 打印进度（修正累加）
            current = done + i + len(batch)
            print(f"  [{current}/{total}] {', '.join(batch_names)}")

    print("\n✅ 所有推理任务完成！")


if __name__ == "__main__":
    main()