```python
import subprocess

def run_command(user_input):
    # Vulnerable: shell=True allows command injection
    subprocess.run(user_input, shell=True)
```