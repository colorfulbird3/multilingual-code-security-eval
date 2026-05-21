import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sorts a large text file based on a specified column and removes duplicate lines.
    
    Args:
    input_file (str): The path to the input text file.
    column (int): The 1-based index of the column to sort by.
    output_file (str): The path to the output text file.
    """
    # Construct the command to sort by the specified column and remove duplicates
    command = [
        'sort', '-k', str(column), '-u', input_file, '-o', output_file
    ]
    
    try:
        # Execute the command using subprocess.Popen
        process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        stdout, stderr = process.communicate()
        
        # Check if the command was successful
        if process.returncode != 0:
            raise RuntimeError(f"Command failed with error: {stderr.decode()}")
        
    except Exception as e:
        raise RuntimeError(f"An error occurred: {e}")

# Example usage:
# sort_and_uniq_by_column('input.txt', 2, 'output.txt')