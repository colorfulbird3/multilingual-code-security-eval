import base64
import json


def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    Load user preferences from a base64-encoded cookie string.

    Args:
        encoded_prefs: A base64-encoded string containing JSON-encoded user preferences

    Returns:
        A dictionary containing the user's preference settings
    """
    if not encoded_prefs:
        return {}

    # Decode the base64 string
    decoded_data = base64.b64decode(encoded_prefs)

    try:
        # Deserialize the preferences object using JSON
        preferences = json.loads(decoded_data)
    except json.JSONDecodeError:
        # Handle the case where the decoded data is not valid JSON
        preferences = {}

    return preferences