Here's the implementation of the `load_preferences_from_cookie` function in Python:

```python
import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    # Decode the Base64 encoded string
    decoded_prefs = base64.b64decode(encoded_prefs)
    
    # Load the preferences using pickle
    prefs = pickle.loads(decoded_prefs)
    
    return prefs
```

This function takes an encoded string as input, decodes it from Base64, and then loads the preferences using the `pickle.loads` method. The result is a dictionary containing the user preferences.