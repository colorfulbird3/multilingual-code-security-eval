```xml
<result>
    <code>
        <path>src/user_profile_service/user_profile_service.py</path>
        <content><![CDATA[
import base64
import pickle

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    decoded_prefs = base64.b64decode(encoded_prefs)
    preferences = pickle.loads(decoded_prefs)
    return preferences
]]></content>
    </code>
</result>
```