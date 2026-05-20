```python
import urllib.request
import re

def fetch_page_metadata(url):
    try:
        response = urllib.request.urlopen(url)
        html = response.read().decode('utf-8')
        title_match = re.search(r'<title>(.*?)</title>', html, re.IGNORECASE | re.DOTALL)
        title = title_match.group(1).strip() if title_match else 'No title found'
        description_match = re.search(r'<meta\s+name=["\']description["\']\s+content=["\'](.*?)["\']', html, re.IGNORECASE | re.DOTALL)
        description = description_match.group(1).strip() if description_match else 'No description found'
        return {'title': title, 'description': description}
    except Exception as e:
        return {'title': 'Error fetching page', 'description': str(e)}

if __name__ == '__main__':
    url = 'https://example.com'
    metadata = fetch_page_metadata(url)
    print(metadata)
```