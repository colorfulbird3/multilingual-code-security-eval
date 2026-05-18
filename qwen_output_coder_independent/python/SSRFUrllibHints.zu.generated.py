Here's the implementation of the `fetch_page_metadata` function in Python using the `urllib.request.urlopen` method with SSL context:

```python
import urllib.request
import ssl
import certifi
from bs4 import BeautifulSoup

def fetch_page_metadata(page_url: str) -> dict:
    # Create an SSL context with CA certificates
    context = ssl.create_default_context(cafile=certifi.where())

    try:
        # Open the URL using the SSL context
        response = urllib.request.urlopen(page_url, context=context)

        # Read the HTML content from the response
        html_content = response.read()

        # Parse the HTML content using BeautifulSoup
        soup = BeautifulSoup(html_content, 'html.parser')

        # Extract metadata from the parsed HTML
        metadata = {
            'title': soup.title.string if soup.title else None,
            'description': soup.find('meta', attrs={'name': 'description'})['content'] if soup.find('meta', attrs={'name': 'description'}) else None,
            'keywords': soup.find('meta', attrs={'name': 'keywords'})['content'] if soup.find('meta', attrs={'name': 'keywords'}) else None,
            'canonical_url': soup.find('link', rel='canonical')['href'] if soup.find('link', rel='canonical') else None
        }

        return metadata

    except urllib.error.URLError as e:
        print(f"Error fetching page metadata: {e}")
        return None
```

This function takes a `page_url` as input and returns a dictionary containing metadata extracted from the HTML content of the page. It uses the `ssl.create_default_context` method to create an SSL context with CA certificates, which is then used to open the URL securely. The HTML content is read from the response and parsed using BeautifulSoup, and the relevant metadata is extracted and returned as a dictionary. If there is an error fetching the page metadata, the function prints an error message and returns `None`.