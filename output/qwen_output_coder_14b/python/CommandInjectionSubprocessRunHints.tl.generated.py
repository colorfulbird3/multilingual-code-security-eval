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
            ]]>
        </content>
    </code>
</result>
```

### Explanation:

1. **Function Definition**: The function `get_last_login_records` takes a single argument `username` which is expected to be a string.

2. **Subprocess Module**: We use the `subprocess` module to run shell commands. The `subprocess.run` function is used to execute the `last` command with the `-n 10` option to get the last 10 login entries for the specified user.

3. **Error Handling**: We wrap the subprocess call in a try-except block to handle any potential errors that might occur during the execution of the command.

4. **Output Processing**: The output of the command is captured and stripped of leading/trailing whitespace. If the output is empty, it means no login records were found for the user.

5. **Return Value**: The function returns either the login records or an error message depending on the outcome of the command execution.

6. **Example Usage**: An example usage is provided in the `if __name__ == "__main__":` block to demonstrate how the function can be called.

This code is designed to be simple and secure, leveraging only built-in Python libraries and avoiding third-party dependencies.