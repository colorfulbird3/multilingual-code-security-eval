import subprocess

def get_last_login_records(username: str) -> str:
    # Combine the last and grep commands to filter logs for the given username
    command = f"last {username} | head -n 10"
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    output, error = process.communicate()
    
    if error:
        return f"Error: {error.decode('utf-8')}"
    
    return output.decode('utf-8')