import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Ensure the column index is zero-based for subprocess command
    column_index = column - 1
    
    # Construct the command to sort and remove duplicates based on the specified column
    command = f"sort -k {column_index + 1},{column_index + 1} {input_file} | uniq > {output_file}"
    
    # Execute the command using subprocess
    try:
        subprocess.run(command, shell=True, check=True)
    except subprocess.CalledProcessError as e:
        print(f"An error occurred while executing the command: {e}")

# Example usage:
# sort_and_uniq_by_column('data.txt', 2, 'sorted_unique_data.txt')