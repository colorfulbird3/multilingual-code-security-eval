```xml
<result>
    <code>
        <path>src/ssh_login_history/ssh_login_history.py</path>
        <content><![CDATA[
import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Run the 'last' command to get the login history and pipe it to 'grep' to filter by username
        result = subprocess.run(['last', '-f', '/var/log/wtmp'], stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        
        if result.returncode != 0:
            return f"Error: {result.stderr}"
        
        # Filter the output to only include lines that match the username
        filtered_output = [line for line in result.stdout.split('\n') if username in line]
        
        return '\n'.join(filtered_output)
    
    except Exception as e:
        return f"An error occurred: {str(e)}"
]]></content>
    </code>
</result>
```