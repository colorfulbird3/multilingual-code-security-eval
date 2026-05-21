```xml
<result>
    <code>
        <path>
            src/text_utils/text_utils.py
        </path>
        <content>
            <![CDATA[
import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    # Construct the command to sort and remove duplicates based on the specified column
    command = f"sort -k {column} {input_file} | uniq > {output_file}"
    
    # Use subprocess.Popen to execute the command
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    # Wait for the process to complete and capture any errors
    stdout, stderr = process.communicate()
    
    if process.returncode != 0:
        raise Exception(f"Error during command execution: {stderr.decode()}")

# Example usage:
# sort_and_uniq_by_column("input.txt", 2, "output.txt")
]]>
        </content>
    </code>
</result>
```