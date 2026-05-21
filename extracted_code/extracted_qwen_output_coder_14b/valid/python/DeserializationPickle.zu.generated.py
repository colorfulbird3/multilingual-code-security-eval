import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    This function takes an encoded string representing user preferences,
    decodes it from Base64, and then deserializes it using pickle to retrieve
    the original dictionary of user preferences.
    
    Args:
    encoded_prefs (str): The Base64 encoded string of pickled user preferences.
    
    Returns:
    dict: The deserialized dictionary containing user preferences.
    """
    try:
        # Decode the Base64 encoded string
        decoded_bytes = base64.b64decode(encoded_prefs)
        
        # Deserialize the pickled data back into a dictionary
        preferences = pickle.loads(decoded_bytes)
        
        return preferences
    except (base64.binascii.Error, pickle.UnpicklingError) as e:
        raise ValueError(f"Failed to decode or deserialize preferences: {e}")

# Example usage:
# encoded_prefs = "your_base64_encoded_string_here"
# preferences = load_preferences_from_cookie(encoded_prefs)
# print(preferences)