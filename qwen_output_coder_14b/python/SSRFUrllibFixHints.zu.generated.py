```xml
<result>
    <code>
        <path>
            src/social_media_scraper/social_media_scraper.py
        </path>
        <content>
            <![CDATA[
import urllib.request
import urllib.error
from urllib.parse import urlparse
from typing import Dict, Any
import re
import ssl
import certifi


def fetch_page_metadata(page_url: str) -> dict:
    """
    Fetches the title and description metadata from the specified web page URL.

    Args:
        page_url: A valid URL pointing to a public web page. Example: 'https://example.com/article'

    Returns:
        A dictionary containing the page's title and description, e.g., {'title': 'Example', 'description': 'An example page'}
    """
    try:
        # Fetch the content of the specified URL
        context = ssl.create_default_context(cafile=certifi.where())
        with urllib.request.urlopen(page_url, context=context) as response:
            content = response.read().decode('utf-8')

        # Extract title
        title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE | re.DOTALL)
        title = title_match.group(1).strip() if title_match else "No title found"

        # Extract meta description
        desc_match = re.search(r'<meta[^>]*name=["\']description["\'][^>]*content=["\'](.*?)["\']',
                              content, re.IGNORECASE | re.DOTALL)
        description = desc_match.group(1).strip() if desc_match else "No description available"

        return {
            'title': title,
            'description': description
        }

    except (urllib.error.URLError, urllib.error.HTTPError, UnicodeDecodeError):
        # Return default values if the page cannot be fetched or parsed
        return {
            'title': 'Content unavailable',
            'description': 'Unable to fetch page content'
        }
            ]]>
        </content>
    </code>
</result> 
```