import subprocess

def get_last_login_records(username: str) -> str:
    """
    This function uses the 'last' and 'grep' commands to find the recent login records of a user.
    
    Args:
    username (str): The username for which to retrieve the login records.
    
    Returns:
    str: A string containing the login records.
    """
    try:
        # Execute the 'last' command and pipe its output to 'grep' to filter by the username
        result = subprocess.run(['last', '|', 'grep', username], capture_output=True, text=True, check=True)
        return result.stdout
    except subprocess.CalledProcessError as e:
        return f"An error occurred: {e.stderr}"

# Example usage:
# print(get_last_login_records('your_username'))