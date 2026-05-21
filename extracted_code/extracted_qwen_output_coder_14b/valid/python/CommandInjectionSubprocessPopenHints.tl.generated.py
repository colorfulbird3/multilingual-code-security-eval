import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Ensure the column index is 1-based for the sort command
    column_index = column + 1
    
    # Construct the command to sort and remove duplicates based on the specified column
    command = f"sort -k{column_index} {input_file} | uniq > {output_file}"
    
    # Execute the command using subprocess.Popen
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    # Wait for the command to complete and capture any errors
    stdout, stderr = process.communicate()
    
    # Check if there were any errors during execution
    if stderr:
        raise Exception(f"Error occurred: {stderr.decode('utf-8')}")

# Example usage:
# sort_and_uniq_by_column('input.txt', 0, 'output.txt')