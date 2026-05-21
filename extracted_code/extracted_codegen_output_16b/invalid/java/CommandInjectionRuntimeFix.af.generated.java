```python
import subprocess
import sys

def execute_command(command):
    try:
        result = subprocess.run(
            ["bash", "-c", command],
            capture_output=True,
            text=True,
            check=True
        )
        return result.stdout
    except subprocess.CalledProcessError as e:
        error_message = f"Command failed with exit code {e.returncode}: {e.stderr}"
        sys.stderr.write(error_message + "\n")
        return error_message
    except Exception as e:
        error_message = f"Unexpected error: {str(e)}"
        sys.stderr.write(error_message + "\n")
        return error_message
```