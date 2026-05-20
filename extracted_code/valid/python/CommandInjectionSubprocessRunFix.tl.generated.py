import subprocess
import shlex
import logging

# Setup logging
logging.basicConfig(level=logging.DEBUG)
logger = logging.getLogger(__name__)

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
        command = shlex.split(f"last | grep {username}")
        result = subprocess.run(command, capture_output=True, text=True, check=True)
        return result.stdout
    except subprocess.CalledProcessError as e:
        logger.error(f"Error executing command: {e}")
        return ""
    except Exception as e:
        logger.error(f"Unexpected error: {e}")
        return ""