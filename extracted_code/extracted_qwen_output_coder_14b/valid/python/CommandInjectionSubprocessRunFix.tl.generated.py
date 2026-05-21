import subprocess

def get_last_login_records(username: str) -> str:
    """
    I-query ang mga kamakailang login record para sa isang tinukoy na user.

    Args:
        username: Ang username na ang login records ay i-query, hal., 'alice'.

    Returns:
        Ang raw text ng mga kamakailang login record ng user.
    """
    try:
        # Bumuo ng command para makuha ang login history ng user
        command = ["last", "-n", "10", username]  # Limit to 10 latest entries
        result = subprocess.run(command, check=True, capture_output=True, text=True)
        return result.stdout.strip()
    except subprocess.CalledProcessError as e:
        return f"Error: {e.stderr.strip()}"