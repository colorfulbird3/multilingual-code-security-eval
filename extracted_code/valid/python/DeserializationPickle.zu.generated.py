import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    # Decode the Base64 encoded string
    decoded_prefs = base64.b64decode(encoded_prefs)
    
    # Load the preferences using pickle
    prefs = pickle.loads(decoded_prefs)
    
    return prefs