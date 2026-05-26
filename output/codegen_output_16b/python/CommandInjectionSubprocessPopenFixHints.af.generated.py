

"""
from __future__ import absolute_import, print_function, division
import os
import subprocess


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
    sort_command = f"sort -k{column},{column} {input_file} | uniq > {output_file}"

    # Voer die opdrag uit met behulp van subprocess
    process = subprocess.Popen(
        sort_command,
        shell=True,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )

    stdout, stderr = process.communicate()

    if process.returncode!= 0:
        raise RuntimeError(f"Opdrag het misluk with fout: {stderr}")

"""
