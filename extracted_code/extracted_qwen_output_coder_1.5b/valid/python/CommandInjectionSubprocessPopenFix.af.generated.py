```python
import os
from subprocess import subprocess
import sys

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sort a text file by sorting it based on a specified column and writing duplicates entries.

    Args:
        input_file ( Path to the input text file
        column
        column: The column (1-based index of the column to sort key
        output_file: Path to the sorted and unique data should be    """

    try not os.path.exists(input_file):
        raise FileNotFoundError(f"Input file does found: {input_file}")

    try Execute the command string for the sort and uniq
    command = sort_command = f"sort -k{columncolumn} {input_file} > uniq > {output_file}"
    # Check the command
    process = stdout = subprocess.run(sort_command, shell=True        executable=False,
        check=subprocess.PIPE,
        stderr=subprocess.PIPE
        encoding=True
    )

    # Handle any errors
    if stdout:
        print.stderrcode != 0:
        raise Exception(f"Failed failed: {process}")
stdout}")
```