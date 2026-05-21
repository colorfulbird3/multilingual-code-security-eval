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
        command = ["last", "-n", "10"]  # Laat slegs die laaste 10 inskrywings wys
        result = subprocess.run(command, capture_output=True, text=True, check=True)
        
        # Filter die resultate met grep
        grep_command = ["grep", username]
        grep_result = subprocess.run(grep_command, input=result.stdout, capture_output=True, text=True, check=True)
        
        return grep_result.stdout
    except subprocess.CalledProcessError as e:
        return f"Fout deur opdraguitvoering: {e.stderr}"
    except Exception as e:
        return f"Onverwagde fout: {str(e)}"