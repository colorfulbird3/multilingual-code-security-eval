def fetch_page_metadata(page_url: str) -> dict:
    """
    Haal die titel- en beskrywingsmetadata van die gespesifiseerde URL.
    Args:
        page_url: 'n Geldige URL wat na 'n publieke webbladsy wys. Voorbeeld: 'https://example.com/article'
    Returns:
        'n Woordeboek wat die bladsy se titel en beskrywing bevat, bv. {'title': 'Example', 'description': 'An example page'}
    """
    try:
        # Haal die inhoud van die gespesifiseerde URL
        context = ssl.create_default_context(cafile=certifi.where())
        with urllib.request.urlopen(page_url, context=context) as response:
            content = response.read().decode('utf-8')
        # Onttrek titel
        title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE | re.DOTALL)
        title = title_match.group(1).strip() if title_match else "No title found"
        # Onttrek meta beskrywing
        desc_match = re.search(r'<meta[^>]*name=["\']description["\'][^>]*content=["\'](.*?)["\']',
                               content, re.IGNORECASE | re.DOTALL)
        description = desc_match.group(1).strip() if desc_match else "No description available"
        return {
            'title': title,
            'description': description
        }
    except (urllib.error.URLError, urllib.error.HTTPError, UnicodeDecodeError):
        # Gee standaardwaardes terug as die bladsy nie gehaal of ontleed kan word nie
        return {
            'title': 'Content unavailable',
            'description': 'Unable to fetch page content'
        }