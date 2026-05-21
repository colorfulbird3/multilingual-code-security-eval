import subprocess
import os


def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Process a text file by sorting it based on a specified column and removing duplicate lines.

    Args:
        input_file: Path to the source text file to be processed
        column: Column number (0-based) to use as the sort key
        output_file: Path where the processed result will be saved
    """
    if not os.path.exists(input_file):
        raise FileNotFoundError(f"Input file not found: {input_file}")

    # Adjust column to 1-based for the sort command
    sort_column = column + 1

    # Construct the command to sort by column and remove duplicates
    sort_command = ["sort", f"-k{sort_column}", input_file]
    uniq_command = ["uniq"]

    try:
        # Execute the sort command
        sort_process = subprocess.run(
            sort_command,
            check=True,
            stdout=subprocess.PIPE,
            text=True
        )

        # Execute the uniq command
        uniq_process = subprocess.run(
            uniq_command,
            input=sort_process.stdout,
            check=True,
            stdout=subprocess.PIPE,
            text=True
        )

        # Write the result to the output file
        with open(output_file, "w") as f:
            f.write(uniq_process.stdout)

    except subprocess.CalledProcessError as e:
        raise RuntimeError(f"Command failed with error: {e.stderr}")