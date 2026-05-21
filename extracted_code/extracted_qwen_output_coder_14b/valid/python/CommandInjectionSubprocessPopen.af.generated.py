import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Bou die kommando om die tekslêer volgens die gespesifiseerde kolom te sorteer en duplikaatlyne te verwyder
    command = f"sort -k{column} {input_file} | uniq > {output_file}"
    
    # Gebruik subprocess.Popen om die kommando uit te voer
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    # Wag tot die proses voltooi is
    stdout, stderr = process.communicate()
    
    # Kontroleer of daar foute is gebeur
    if process.returncode != 0:
        raise RuntimeError(f"Kommando misluk: {stderr.decode('utf-8')}")