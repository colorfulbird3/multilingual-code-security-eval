import subprocess

# Vulnerable code using subprocess.Popen with shell=True
user_input = "some_user_input"
subprocess.Popen(f"echo {user_input}", shell=True)

# Secure code using subprocess.run without shell=True
subprocess.run(["echo", user_input])