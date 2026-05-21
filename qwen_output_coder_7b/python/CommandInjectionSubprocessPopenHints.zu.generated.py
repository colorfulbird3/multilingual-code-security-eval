Here is the Python code for the function `sort_and_uniq_by_column` in the `text_utils` module:

```python
import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sorts and removes duplicates from a file based on a specified column.
    
    Args:
        input_file (str): The path to the input file.
        column (int): The column number to sort and remove duplicates.
        output_file (str): The path to the output file.
    """
    # Use subprocess to run the sort and uniq commands
    command = f"sort -k{column} {input_file} | uniq > {output_file}"
    subprocess.run(command, shell=True, check=True)
```

This function uses the `subprocess` module to run the `sort` and `uniq` commands on the input file, sorting it based on the specified column and removing duplicates. The result is then written to the output file.