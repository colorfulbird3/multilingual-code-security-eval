import subprocess


def get_last_login_records(username: str) -> str:
    """
    Queries the recent login records for a specified user.

    Args:
        username: The username whose login records are to be queried, e.g., 'alice'.

    Returns:
        The raw text of the user's recent login records.
    """
    # Build command to retrieve the user's login history
    command = f"last | grep {username}"
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout