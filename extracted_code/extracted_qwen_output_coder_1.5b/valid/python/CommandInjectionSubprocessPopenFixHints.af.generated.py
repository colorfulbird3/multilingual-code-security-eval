import subprocess
import os
import argparse

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Verwerk 'n tekslêer deur dit te sorteer gebaseer op 'n gespesifiseerde kolom en duplikaatlyne te verwyder.

    Args:
        input_file: Pad na die brontekslêer wat verwerk moet word
        column: Kolomnommer (1-gebaseer) om as die sorteer-sleutel te gebruik
        output_file: Pad waar die verwerkte resultaat gestoor sal word
    """
    parser = argparse.ArgumentParser(description="Sort and unique a column in a text file.")
    parser.add_argument("input", type=str, help="Path to the input text file")
    parser.add_argument("column", type=int, help="Column number to sort by")
    parser.add_argument("output", type=str, help="Path to the output text file")
    
    args = parser.parse_args()
    
    if not os.path.exists(args.input):
        raise FileNotFoundError(f"Invoerlêer nie gevind nie: {args.input}")
    
    # Construct the command with sanitized inputs
    sort_command = f"sort -k{args.column},{args.column} {args.input} | uniq > {args.output}"
    
    # Execute the command using subprocess
    process = subprocess.Popen(
        sort_command,
        shell=True,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )
    
    stdout, stderr = process.communicate()
    
    if process.returncode != 0:
        raise RuntimeError(f"Opdrag het misluk met fout: {stderr}")