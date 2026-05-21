import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    # Decode the Base64 encoded string
    decoded_bytes = base64.b64decode(encoded_prefs)
    
    # Deserialize the bytes to get the dictionary of user preferences
    user_preferences = pickle.loads(decoded_bytes)
    
    return user_preferences