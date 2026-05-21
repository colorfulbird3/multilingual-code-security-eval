```xml
<result>
    <code>
        <path>
            src/ssh_login_history/ssh_login_history.py
        </path>
        <content>
            <![CDATA[
import subprocess

def get_last_login_records(username: str) -> str:
    """
    Function to retrieve the last login records for a given username using SSH.
    
    Args:
    username (str): The username of the user whose login records are to be retrieved.
    
    Returns:
    str: A string containing the last login records for the specified user.
    """
    try:
        # Command to get the last login records using last command and grep to filter by username
        command = f"last {username} | grep {username}"
        # Execute the command using subprocess
        result = subprocess.run(command, shell=True, check=True, capture_output=True, text=True)
        return result.stdout.strip()
    except subprocess.CalledProcessError as e:
        return f"Error retrieving last login records: {e.stderr.strip()}"

# Example usage
if __name__ == "__main__":
    username = "alice"
    print(get_last_login_records(username))
            ]]>
        </content>
    </code>
</result>
```