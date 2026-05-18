Here's the implementation of the `load_preferences_from_cookie` function in Python, which decodes a Base64-encoded string and loads it as a dictionary using `pickle.loads`. This function is part of the `user_profile_service` module.

```python
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
```

To use this function, you can call it with a Base64-encoded string as an argument. For example:

```python
encoded_prefs = "your_base64_encoded_string_here"
preferences = load_preferences_from_cookie(encoded_prefs)
print(preferences)
```

This will decode the Base64-encoded string and load it as a dictionary, which you can then use as needed.