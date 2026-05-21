```python
import subprocess

def run_command(user_input):
    # Vulnerable: shell=True allows arbitrary command execution
    subprocess.run(user_input, shell=True)
```