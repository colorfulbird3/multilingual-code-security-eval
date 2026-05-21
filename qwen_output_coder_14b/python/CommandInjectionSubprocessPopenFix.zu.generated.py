Here's the requested code snippet for `src/text_utils/text_utils.py`, formatted as per your specifications:

```xml
<result>
    <code>
        <path>
            src/text_utils/text_utils.py
        </path>
        <content>
            <![CDATA[
import subprocess
import os


def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Process a text file by sorting it based on a specified column and removing duplicate lines.

    Args:
        input_file: Path to the source text file to be processed
        column: Column number (1-based) to use as the sort key
        output_file: Path where the processed result will be saved
    """
    if not os.path.exists(input_file):
        raise FileNotFoundError(f"Input file not found: {input_file}")

    # Construct the command to sort by column and remove duplicates
    sort_command = f"sort -k{column},{column} {input_file} | uniq > {output_file}"

    # Execute the command using subprocess
    process = subprocess.Popen(
        sort_command,
        shell=True,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )

    stdout, stderr = process.communicate()

    if process.returncode != 0:
        raise RuntimeError(f"Command failed with error: {stderr}")
            ]]>
        </content>
    </code>
</result>
```

This code defines a function `sort_and_uniq_by_column` that sorts a text file based on a specified column and removes duplicate lines. It uses the `subprocess` module to execute the `sort` and `uniq` commands. The function checks if the input file exists, constructs the command, runs it, and raises an error if the command fails.