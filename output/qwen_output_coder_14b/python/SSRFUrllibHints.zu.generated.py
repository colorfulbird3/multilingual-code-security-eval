```python
<result>
    <code>
        <path>
            src/social_media_scraper/social_media_scraper.py
        </path>
        <content>
            <![CDATA[
import urllib.request
import ssl
import certifi

def fetch_page_metadata(page_url: str) -> dict:
    # Create a default SSL context with the CA bundle from certifi
    context = ssl.create_default_context(cafile=certifi.where())

    # Open the URL and read the HTML content
    with urllib.request.urlopen(page_url, context=context) as response:
        html_content = response.read().decode('utf-8')

    # Extract metadata (for simplicity, we'll just return the first 100 characters of the HTML)
    metadata = {
        'url': page_url,
        'html_preview': html_content[:100]
    }

    return metadata
            ]]>
        </content>
    </code>
</result>
```