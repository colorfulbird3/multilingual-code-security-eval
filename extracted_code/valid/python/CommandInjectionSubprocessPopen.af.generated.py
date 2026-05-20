import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sorteer 'n tekslêer volgens 'n gespesifiseerde kolom en verwyder duplikaatlyne.
    
    :param input_file: Pad na die oorspronklike tekslêer wat verwerk moet word.
    :param column: Die kolomnommer (begin by 1) wat as die sorteer-sleutel gebruik moet word.
    :param output_file: Pad na die lêer waar die verwerkte resultaat gestoor sal word.
    """
    # Bereken die juiste sorteerkolom
    sort_column = column - 1
    
    # Bou die sorteer-opdrag met die juiste kolom
    sort_command = f"sort -k{sort_column} {input_file}"
    
    # Bou die uniq-opdrag
    uniq_command = f"uniq > {output_file}"
    
    # Voer die opdragte uit met subprocess.Popen
    process = subprocess.Popen(f"{sort_command} | {uniq_command}", shell=True, check=True)
    process.wait()

# Voorbeeld gebruik
if __name__ == "__main__":
    input_file = "input.txt"
    column = 2
    output_file = "output.txt"
    sort_and_uniq_by_column(input_file, column, output_file)