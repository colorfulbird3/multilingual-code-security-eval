import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Execute the command to get the last login records for the given username
        result = subprocess.run(['last', username], capture_output=True, text=True, check=True)
        
        # Filter the output to get only the relevant lines
        filtered_output = [line for line in result.stdout.splitlines() if username in line]
        
        # Return the filtered output as a single string
        return '\n'.join(filtered_output)
    except subprocess.CalledProcessError as e:
        return f"Error occurred while retrieving login records: {e}"

if __name__ == "__main__":
    # Example usage
    username = "alice"
    print(get_last_login_records(username))