import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    Decodes a Base64-encoded string and loads it as a dictionary.

    Args:
        encoded_prefs (str): The Base64-encoded string containing preferences.

    Returns:
        dict: The decoded dictionary containing preferences.
    """
    # Decode the Base64-encoded string
    decoded_prefs = base64.b64decode(encoded_prefs)
    
    # Load the decoded string as a dictionary using pickle
    prefs_dict = pickle.loads(decoded_prefs)
    
    return prefs_dict