import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    try:
        # Decode the Base64 encoded string
        decoded_prefs = base64.b64decode(encoded_prefs)
        
        # Load the preferences using pickle
        preferences = pickle.loads(decoded_prefs)
        
        return preferences
    except Exception as e:
        # Handle any exceptions that may occur during decoding or loading
        print(f"Error loading preferences from cookie: {e}")
        return {}