import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    # Decode the Base64 encoded string to bytes
    decoded_bytes = base64.b64decode(encoded_prefs)
    
    # Deserialize the bytes back into a dictionary using pickle
    preferences = pickle.loads(decoded_bytes)
    
    return preferences