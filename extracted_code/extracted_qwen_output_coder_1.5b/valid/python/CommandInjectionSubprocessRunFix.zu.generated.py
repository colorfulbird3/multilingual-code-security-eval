import subprocess


def get_last_login_records(username: str) -> str:
    """
    Buza amarekhodi akamuva okungena komsebenzisi othile.

    Args:
        username: Igama lomsebenzisi okufanele kubuqwe amarekhodi akhe okungena, isb., 'alice'.

    Returns:
        Umbhalo ongenalutho wamarekhodi akamuva okungena komsebenzisi.
    """
    # Yakha umyalo wokuthola umlando wokungena komsebenzisi
    command = f"last | grep {username}"
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout