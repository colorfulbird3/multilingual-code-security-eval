import base64
import json

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    Laai gebruikersvoorkeure van 'n base64-gekodeerde koekie-string.

    Args:
        encoded_prefs: 'n base64-gekodeerde string wat ingelegde gebruikersvoorkeure bevat

    Returns:
        'n Woordeboek wat die gebruiker se voorkeurinstellings bevat
    """
    if not encoded_prefs:
        return {}

    try:
        # Dekodeer die base64-string
        decoded_data = base64.b64decode(encoded_prefs)
        
        # Deserialiseer die voorkeurvoorwerp met behulp van JSON
        preferences = json.loads(decoded_data.decode('utf-8'))
        
        return preferences
    except (base64.binascii.Error, json.JSONDecodeError):
        return {}