import urllib.request
import urllib.error
from bs4 import BeautifulSoup
from typing import Dict, Any
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