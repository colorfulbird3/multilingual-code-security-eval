import subprocess

def run_command(command):
    result = subprocess.run(command, capture_output=True, text=True)
    return result.stdout