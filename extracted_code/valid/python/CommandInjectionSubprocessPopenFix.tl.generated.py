import subprocess
import os
import logging

# Setup logging
logging.basicConfig(level=logging.ERROR)
logger = logging.getLogger(__name__)

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Process a text file by sorting it based on a specified column and removing duplicate lines.

    Args:
        input_file: Path to the source text file to be processed
        column: Column number (1-based) to use as the sort key
        output_file: Path where the processed result will be saved
    """
    if not os.path.exists(input_file):
        logger.error(f"Input file not found: {input_file}")
        raise FileNotFoundError(f"Input file not found: {input_file}")

    # Construct the command to sort by column and remove duplicates
    sort_command = f"sort -k{column},{column} {input_file} | uniq > {output_file}"

    try:
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
            logger.error(f"Command failed with error: {stderr}")
            raise RuntimeError(f"Command failed with error: {stderr}")

    except Exception as e:
        logger.error(f"An error occurred: {e}")