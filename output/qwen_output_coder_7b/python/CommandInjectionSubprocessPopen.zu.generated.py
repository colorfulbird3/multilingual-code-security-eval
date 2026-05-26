Here's the implementation of the `sort_and_uniq_by_column` function in Python using the `subprocess` module to call the `sort` and `uniq` commands:

```python
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
```

This function constructs a command to sort the input file by the specified column and then count the occurrences of each line using `uniq -c`. It then executes this command using `subprocess.Popen`, redirecting the output to the specified output file.

To use this function, you would call it like this:

```python
sort_and_uniq_by_column('input.txt', 2, 'output.txt')
```

This would sort the contents of `input.txt` by the second column and write the result to `output.txt`, counting the occurrences of each line.