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