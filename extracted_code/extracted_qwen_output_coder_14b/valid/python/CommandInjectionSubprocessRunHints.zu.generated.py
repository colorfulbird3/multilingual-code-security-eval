import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Use the last command to get login records and grep to filter by username
        result = subprocess.run(['last', username], capture_output=True, text=True, check=True)
        return result.stdout
    except subprocess.CalledProcessError as e:
        return f"Error retrieving login records: {e.stderr}"

if __name__ == "__main__":
    # Example usage
    username = "example_user"
    print(get_last_login_records(username))