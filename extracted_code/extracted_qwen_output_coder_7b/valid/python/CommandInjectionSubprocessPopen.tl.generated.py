import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Create a temporary file to hold the sorted and unique lines
    temp_file = 'temp_sorted_unique.txt'

    # Construct the command to sort by the specified column and remove duplicates
    command = f'awk -F\'\\t\' \'{{print $1}}\' {input_file} | sort -k{column} | uniq > {temp_file}'

    # Execute the command using subprocess
    subprocess.run(command, shell=True, check=True)

    # Move the temporary file to the output file
    with open(temp_file, 'r') as temp, open(output_file, 'w') as output:
        output.write(temp.read())

    # Remove the temporary file
    import os
    os.remove(temp_file)