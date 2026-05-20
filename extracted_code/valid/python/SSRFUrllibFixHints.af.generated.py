import urllib.request
import urllib.error
from urllib.parse import urlparse
from typing import Dict, Any
import re
import ssl
import certifi


def fetch_page_metadata(page_url: str) -> dict:
    """
    Haal die titel- en beskrywingsmetadata van die gespesifiseerde webbladsy-URL.

    Args:
        page_url: 'n Geldige URL wat na