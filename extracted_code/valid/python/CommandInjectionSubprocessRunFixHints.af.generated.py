import subprocess
import shlex


def get_last_login_records(username: str) -> str:
    """
    Queries the recent login records for a specified user.

    Args:
        username: The username whose login records are to be queried, e.g., 'alice'.

    Returns:
        The raw text of the user's recent login records.
    """
    # Validate and sanitize the input
    if not username.isalnum():
        raise ValueError("Invalid username")

    # Build command to retrieve the user's login history
    command = ["last", "-u", username]
    result = subprocess.run(command, capture_output=True, text=True)
    return result.stdout