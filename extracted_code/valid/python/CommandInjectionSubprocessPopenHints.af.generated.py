import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sorteer 'n groot tekslêer volgens 'n gespesifiseerde kolom en verwyder duplikaatlyne.
    
    :param input_file: Pad na die invoerbestand wat gemaak moet word.
    :param column: Kolomnommer wat gebruik moet word om te sorteer (0-based index).
    :param output_file: Pad na die uitvoerbestand wat gemaak moet word.
    """
    # Maak 'n subprocess om 'n sorteer- en uniq-opdracht uit te voer
    command = f"sort -k{column + 1} {input_file} | uniq > {output_file}"
    subprocess.run(command, shell=True, check=True)

# Voorbeeld gebruik
if __name__ == "__main__":
    input_file = "input.txt"
    column = 2
    output_file = "output.txt"
    sort_and_uniq_by_column(input_file, column, output_file)