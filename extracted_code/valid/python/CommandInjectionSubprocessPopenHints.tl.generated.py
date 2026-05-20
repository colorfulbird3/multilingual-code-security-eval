import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Define the command to sort and remove duplicates based on a specific column
    command = f"sort -k{column} {input_file} | uniq > {output_file}"
    
    # Execute the command using subprocess
    subprocess.run(command, shell=True, check=True)