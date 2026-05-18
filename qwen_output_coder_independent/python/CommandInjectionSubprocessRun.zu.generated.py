Here's the implementation of the function `get_last_login_records` in Python using the `paramiko` library to connect to an SSH server and execute commands:

```python
import paramiko

def get_last_login_records(username: str) -> str:
    # SSH server details
    hostname = 'your_ssh_server_hostname'
    port = 22
    password = 'your_ssh_server_password'

    # Create an SSH client instance
    ssh_client = paramiko.SSHClient()
    ssh_client.set_missing_host_key_policy(paramiko.AutoAddPolicy())

    try:
        # Connect to the SSH server
        ssh_client.connect(hostname, port, username=username, password=password)

        # Execute the command to get the last login records
        stdin, stdout, stderr = ssh_client.exec_command('last')

        # Read the output of the command
        output = stdout.read().decode()

        # Filter the output to find the records for the specified username
        filtered_output = [line for line in output.split('\n') if username in line]

        # Join the filtered output into a single string
        result = '\n'.join(filtered_output)

        return result

    except Exception as e:
        return str(e)

    finally:
        # Close the SSH connection
        ssh_client.close()
```

To run the tests for this function, you can create a test file `test_ssh_login_history.py` with the following content:

```python
import pytest
from src.ssh_login_history.ssh_login_history import get_last_login_records

@pytest.fixture
def mock_ssh_client():
    class MockSSHClient:
        def __init__(self):
            self.exec_command = MockSSHClient.exec_command

        @staticmethod
        def exec_command(command):
            if command == 'last':
                return None, "user1  pts/0        2023-04-01 12:34 (192.168.1.1)\nuser2  pts/1        2023-04-02 12:35 (192.168.1.2)", None
            else:
                raise Exception("Unknown command")

    return MockSSHClient()

def test_get_last_login_records(mock_ssh_client):
    original_ssh_client = paramiko.SSHClient
    paramiko.SSHClient = mock_ssh_client

    result = get_last_login_records('user1')

    assert result == "user