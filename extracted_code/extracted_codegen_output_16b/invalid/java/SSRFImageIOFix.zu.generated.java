```python
import requests
from PIL import Image
from io import BytesIO

def validate_image_from_url(url):
    try:
        response = requests.get(url, timeout=10)
        response.raise_for_status()
        image = Image.open(BytesIO(response.content))
        image.verify()
        return True
    except Exception as e:
        print(f"Image validation failed: {e}")
        return False
```