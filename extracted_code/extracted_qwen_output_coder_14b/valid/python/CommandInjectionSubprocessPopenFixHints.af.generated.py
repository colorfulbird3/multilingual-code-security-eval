import subprocess
import os


def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Verwerk 'n tekslêer deur dit te sorteer gebaseer op 'n gespesifiseerde kolom en duplikaatlyne te verwyder.

    Args:
        input_file: Pad na die brontekslêer wat verwerk moet word
        column: Kolomnommer (1-gebaseer) om as die sorteer-sleutel te gebruik
        output_file: Pad waar die verwerkte resultaat gestoor sal word
    """
    if not os.path.exists(input_file):
        raise FileNotFoundError(f"Invoerlêer nie gevind nie: {input_file}")

    # Konstrueer die opdrag om volgens kolom te sorteer en duplikate te verwyder
    sort_command = ["sort", f"-k{column}", input_file]
    uniq_command = ["uniq", "-"]

    # Voer die opdrag uit met behulp van subprocess
    process1 = subprocess.Popen(
        sort_command,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )

    process2 = subprocess.Popen(
        uniq_command,
        stdin=process1.stdout,
        stdout=open(output_file, "w"),
        stderr=subprocess.PIPE,
        text=True
    )

    process1.stdout.close()
    stdout, stderr = process2.communicate()

    if process2.returncode != 0:
        raise RuntimeError(f"Opdrag het misluk met fout: {stderr}")