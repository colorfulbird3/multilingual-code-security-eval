import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    try:
        # Decode the Base64 encoded string
        decoded_prefs = base64.b64decode(encoded_prefs)
        
        # Load the preferences using pickle
        preferences = pickle.loads(decoded_prefs)
        
        return preferences
    except (base64.binascii.Error, pickle.UnpicklingError) as e:
        # Handle decoding or unpickling errors
        print(f"Error loading preferences from cookie: {e}")
        return {}
    except Exception as e:
        # Handle any other unexpected errors
        print(f"Unexpected error: {e}")
        return {}

# Example usage:
# encoded_prefs = "your_encoded_preferences_string_here"
# prefs = load_preferences_from_cookie(encoded_prefs)
# print(prefs)