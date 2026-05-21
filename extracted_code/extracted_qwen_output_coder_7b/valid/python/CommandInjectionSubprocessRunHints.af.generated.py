import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Combine the 'last' and 'grep' commands to filter logs for the given username
        command = f"last -f /var/log/auth.log | grep '{username}'"
        result = subprocess.run(command, shell=True, check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        return result.stdout.decode('utf-8')
    except subprocess.CalledProcessError as e:
        return f"Error: {e.stderr.decode('utf-8')}"
    except Exception as e:
        return f"An unexpected error occurred: {str(e)}"