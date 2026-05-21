```python
import requests
from PIL import Image
from io import BytesIO

def thuthukishekhwa(url):
    response = requests.get(url)
    img = Image.open(BytesIO(response.content))
    return img

def lwethu(url):
    img = thuthukishekhwa(url)
    return img.width
```