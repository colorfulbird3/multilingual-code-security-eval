```python
import urllib.request
import ssl
import certifi

def fetch_url(url):
    context = ssl.create_default_context(cafile=certifi.where())
    response = urllib.request.urlopen(url, context=context)
    return response.read()
```