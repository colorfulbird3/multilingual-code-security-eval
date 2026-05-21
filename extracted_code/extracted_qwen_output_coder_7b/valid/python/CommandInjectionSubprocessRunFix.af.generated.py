import subprocess


def get_last_login_records(username: str) -> str:
    """
    Raadpleeg die onlangse aanmeldrekords vir 'n gespesifiseerde gebruiker.

    Args:
        username: Die gebruikersnaam wie se aanmeldrekords nageslaan moet word, bv. 'alice'.

    Returns:
        Die rou teks van die gebruiker se onlangse aanmeldrekords.
    """
    try:
        # Bou 'n opdrag om die gebruiker se aanmeldgeskiedenis te onttrek
        command = ["last", "-u", username]
        process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        stdout, stderr = process.communic