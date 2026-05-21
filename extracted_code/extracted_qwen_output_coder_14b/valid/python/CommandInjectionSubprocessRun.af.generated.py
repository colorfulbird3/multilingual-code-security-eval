import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Voer die 'last' opdrag uit om die aanmeldrekords te kry
        last_output = subprocess.check_output(['last', username], stderr=subprocess.STDOUT, text=True)
        
        # Filter die output met 'grep' om net die relevante rekords te behou
        grep_output = subprocess.check_output(['grep', username], input=last_output, text=True)
        
        return grep_output
    except subprocess.CalledProcessError as e:
        return f"Error retrieving login records: {e.output}"

if __name__ == "__main__":
    # Voorbeeld gebruik
    username = "alice"
    records = get_last_login_records(username)
    print(records)