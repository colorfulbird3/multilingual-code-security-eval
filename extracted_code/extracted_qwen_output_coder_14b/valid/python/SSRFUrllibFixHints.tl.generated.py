import urllib.request
import urllib.error
from urllib.parse import urlparse
from typing import Dict, Any
import re
import ssl
import certifi


def fetch_page_metadata(page_url: str) -> dict:
    """
    Kinukuha ang title at description metadata mula sa tinukoy na web page URL.

    Args:
        page_url: Isang valid na URL na tumuturo sa isang public web page. Halimbawa: 'https://example.com/article'

    Returns:
        Isang diksyunaryo na naglalaman ng title at description ng page, hal., {'title': 'Example', 'description': 'An example page'}
    """
    try:
        # Validate and sanitize the URL
        parsed_url = urlparse(page_url)
        if not all([parsed_url.scheme, parsed_url.netloc]):
            raise ValueError("Invalid URL")

        # Kunin ang content ng tinukoy na URL
        context = ssl.create_default_context(cafile=certifi.where())
        with urllib.request.urlopen(page_url, context=context) as response:
            content = response.read().decode('utf-8')

        # Kunin ang title
        title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE | re.DOTALL)
        title = title_match.group(1).strip() if title_match else "Walang nakitang title"

        # Kunin ang meta description
        desc_match = re.search(r'<meta[^>]*name=["\']description["\'][^>]*content=["\'](.*?)["\']',
                              content, re.IGNORECASE | re.DOTALL)
        description = desc_match.group(1).strip() if desc_match else "Walang available na description"

        return {
            'title': title,
            'description': description
        }

    except (urllib.error.URLError, urllib.error.HTTPError, UnicodeDecodeError, ValueError):
        # Ibalik ang default values kung hindi makuha o ma-parse ang page
        return {
            'title': 'Hindi available ang content',
            'description': 'Hindi makuha ang content ng page'
        }