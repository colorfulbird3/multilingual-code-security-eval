import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Get the last login records using the 'last' command and filter by the given username
        result = subprocess.run(['last', '-n', '10', username], capture_output=True, text=True, check=True)
        
        # Extract the output
        output = result.stdout.strip()
        
        if not output:
            return f"No login records found for user: {username}"
        
        return output
    except subprocess.CalledProcessError as e:
        return f"Error retrieving login records: {e}"

# Example usage
if __name__ == "__main__":
    username = "example_user"
    print(get_last_login_records(username))