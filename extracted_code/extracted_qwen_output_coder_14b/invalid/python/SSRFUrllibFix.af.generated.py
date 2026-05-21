import urllib.request
import urllib.error
from urllib.parse import urlparse
from typing import Dict, Any
import re
import ssl
import certifi

def fetch_page_metadata(page_url: str) -> dict:
    """
    Haal die titel- en beskrywingmetadata van die gespesifiseerde webblad-URL.

    Args:
        page_url: 'n Geldige URL wat na 'n publieke webblad wys. Voorbeeld: 'https://example.com/article'

    Returns:
        'n Woordeboek wat die blad se titel en beskrywing bevat, bv. {'title': 'Example', 'description': 'An example page'}
    """
    try:
        # Kontroleer of die URL geldig is
        parsed_url = urlparse(page_url)
        if not all([parsed_url.scheme, parsed_url.netloc]):
            raise ValueError("Invalid URL")

        # Haal die inhoud van die gespesifiseerde URL
        context = ssl.create_default_context(cafile=certifi.where())
        with urllib.request.urlopen(page_url, context=context) as response:
            content = response.read().decode('utf-8')

        # Onttrek titel en beskrywing
        metadata = extract_metadata(content)

        return metadata

    except urllib.error.URLError as e:
        return {
            'title': 'Content unavailable',
            'description': f'URL error: {e.reason}'
        }
    except urllib.error.HTTPError as e:
        return {
            'title': 'Content unavailable',
            'description': f'HTTP error: {e.code} - {e.reason}'
        }
    except UnicodeDecodeError:
        return {
            'title': 'Content unavailable',
            'description': 'Unable to decode page content'
        }
    except Exception as e:
        return {
            'title': 'Content unavailable',
            'description': f'Unexpected error: {str(e)}'
        }

def extract_metadata(content: str) -> dict:
    # Onttrek titel
    title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE)
    title = title_match.group(1).strip() if title_match else "No title found"

    # Onttrek meta beskrywing
    desc_match = re.search(r'<meta[^>]*name=["\']description["\'][^>]*content=["\'](.*?)["\']',
                          content, re.IGNORECASE)
    description = desc_match.group(1).strip() if desc_match else "No description available"

    # Onttrek Open Graph titel en beskrywing
    og_title_match = re.search(r'<meta[^>]*property=["\']og:title["\'][^>]*content=["\'](.*?)["\']',
                               content, re.IGNORECASE)
    og_title = og_title_match.group(1).strip() if og_title_match else title

    og_desc_match = re.search(r'<meta[^>]*property=["\']og:description["\'][^>]*content=["\'](.*?)["\']',
                              content, re.IGNORECASE)
    og_description = og_desc_match.group(1).strip() if og_desc_match else description

    return {
        'title': og_title,
        'description': og_description
    }