import os
import subprocess
import shutil
from pathlib import Path
from concurrent.futures import ThreadPoolExecutor, as_completed

# ================= 配置 =================
CODEQL_EXE = r"E:\multilingual-code-security-eval\codeql\codeql\codeql.exe"
EXTRACTED_DIR = Path(r"E:\multilingual-code-security-eval\extracted_code")
MAX_WORKERS = 4          # 并发模型数

# 语言配置
LANGS = {
    "python": {
        "ext": ".py",
        "query_pack": "codeql/python-queries",
    },
    "cpp": {
        "ext": ".cpp",
        "query_pack": "codeql/cpp-queries",
        "build_mode": "none",
    },
    "java": {
        "ext": ".java",
        "query_pack": "codeql/java-queries",
    },
}
# =========================================

def run_cmd(cmd, cwd=None):
    """运行命令，捕获输出并打印，返回成功与否"""
    print(f"    [CMD] {' '.join(cmd)}")
    # 关键修复：指定文本编码为 utf-8，并忽略非致命错误
    proc = subprocess.run(
        cmd,
        cwd=cwd,
        capture_output=True,
        text=True,
        encoding="utf-8",
        errors="replace",   # 无法解码的字节用 � 代替，避免 UnicodeDecodeError
    )
    if proc.returncode != 0:
        print(f"    [ERR] {proc.stderr[:300]}")
    return proc.returncode == 0

def scan_language(model_name, validity, lang, lang_dir, result_dir, task_num, task_total):
    """扫描单个语言，支持断点续跑"""
    sarif_file = result_dir / f"{validity}_{lang}_results.sarif"
    if sarif_file.exists():
        print(f"  [{task_num}/{task_total}] {validity}/{lang} 结果已存在，跳过。")
        return True

    print(f"  [{task_num}/{task_total}] {validity}/{lang} 扫描中...")
    cfg = LANGS[lang]
    db_dir = lang_dir / f"{lang}-db"

    # 构建 create database 命令
    create_cmd = [
        CODEQL_EXE, "database", "create", str(db_dir),
        "--language", lang,
        "--overwrite",
        "--source-root", str(lang_dir),
    ]
    if lang == "cpp":
        create_cmd += ["--build-mode", "none"]
    elif lang == "java":
        if shutil.which("javac"):
            create_cmd += ["--command", "cmd /c javac *.java || exit 0"]
        else:
            create_cmd += ["--build-mode", "none"]

    if not run_cmd(create_cmd, cwd=str(lang_dir)):
        print(f"  [{task_num}/{task_total}] {validity}/{lang} 数据库创建失败。")
        return False

    analyze_cmd = [
        CODEQL_EXE, "database", "analyze", str(db_dir),
        "--format", "sarif-latest",
        "--output", str(sarif_file),
        cfg["query_pack"],
    ]
    if not run_cmd(analyze_cmd, cwd=str(lang_dir)):
        print(f"  [{task_num}/{task_total}] {validity}/{lang} 分析失败。")
        return False

    print(f"  [{task_num}/{task_total}] {validity}/{lang} 完成。")
    return True

def process_model(model_dir, model_idx, model_total):
    """处理单个模型目录"""
    model_name = model_dir.name
    result_dir = model_dir / "codeql_results"
    result_dir.mkdir(exist_ok=True)

    tasks = []
    for validity in ("valid", "invalid"):
        val_dir = model_dir / validity
        if not val_dir.exists():
            continue
        for lang, cfg in LANGS.items():
            lang_dir = val_dir / lang
            if not lang_dir.exists():
                continue
            if not any(lang_dir.glob(f"*{cfg['ext']}")):
                continue
            tasks.append((validity, lang, lang_dir))

    task_total = len(tasks)
    print(f"\n模型 [{model_idx}/{model_total}] {model_name} (共 {task_total} 个任务)")

    for i, (validity, lang, lang_dir) in enumerate(tasks, 1):
        scan_language(model_name, validity, lang, lang_dir, result_dir, i, task_total)

    print(f"模型 [{model_idx}/{model_total}] {model_name} 处理完毕。")

def main():
    # 提前下载查询包
    print("下载查询包...")
    for pack in ["codeql/python-queries", "codeql/cpp-queries", "codeql/java-queries"]:
        run_cmd([CODEQL_EXE, "pack", "download", pack])

    model_dirs = list(EXTRACTED_DIR.glob("extracted_*"))
    if not model_dirs:
        print("未找到任何模型目录！")
        return

    total_models = len(model_dirs)
    print(f"\n找到 {total_models} 个模型目录，开始并发扫描（最多 {MAX_WORKERS} 个同时进行）...")

    with ThreadPoolExecutor(max_workers=MAX_WORKERS) as executor:
        futures = {
            executor.submit(process_model, d, idx, total_models): d
            for idx, d in enumerate(model_dirs, 1)
        }
        for future in as_completed(futures):
            d = futures[future]
            try:
                future.result()
            except Exception as e:
                print(f"[{d.name}] 处理异常: {e}")

    print("\n所有扫描任务完成！")

if __name__ == "__main__":
    main()