import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Construct the command to sort and uniq by the specified column
    command = [
        'sort',
        '-k', str(column),  # Sort by the specified column
        input_file,
        '|',
        'uniq',
        '-c'  # Count occurrences of each line
    ]

    # Use subprocess.Popen to execute the command
    with open(output_file, 'w') as outfile:
        process = subprocess.Popen(command, stdout=outfile, shell=True)
        process.wait()