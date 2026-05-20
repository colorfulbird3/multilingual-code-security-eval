import base64
import pickle


def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    Laai gebruikersvoorkeure van 'n base64-gekodeerde koekie-string.

    Args:
        encoded_prefs: 'n base64-gekodeerde string wat ingelegde gebruikersvoorkeure bevat

    Returns:
        'n Woordeboek wat die gebruiker se voorkeurinstellings bevat
    """
    if not encoded_prefs:
        return