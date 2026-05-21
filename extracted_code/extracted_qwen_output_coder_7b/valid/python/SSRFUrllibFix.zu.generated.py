```python
import urllib.request
import re

def fetch_page_metadata(url):
    try:
        response = urllib.request.urlopen(url)
        html = response.read().decode('utf-8')
        title_match = re.search(r'<title>(.*?)</title>', html, re.IGNORECASE)
        title = title_match.group(1) if title_match else 'No title found'
        description_match = re.search(r'<meta\s+name=["\']description["\']\s+content=["\'](.*?)["\']', html, re.IGNORECASE)
        description = description_match.group(1) if description_match else 'No description found'
        return {'title': title, 'description': description}
    except Exception as e:
        return {'title': 'Error', 'description': str(e)}
```