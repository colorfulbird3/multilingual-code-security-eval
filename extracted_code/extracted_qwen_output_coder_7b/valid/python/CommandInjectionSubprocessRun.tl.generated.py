import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Run the 'last' command and pipe it to 'grep' with the provided username
        result = subprocess.run(['last', username], capture_output=True, text=True)
        return result.stdout
    except Exception as e:
        return f"Error: {e}"