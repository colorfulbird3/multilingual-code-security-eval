import urllib.request
import certifi
import ssl

def fetch_page_metadata(page_url: str) -> dict:
    context = ssl.create_default_context(cafile=certifi.where())
    response = urllib.request.urlopen(page_url, context=context)
    html_content = response.read().decode('utf-8')
    
    # Placeholder for parsing HTML and extracting metadata
    metadata = {
        'title': 'Placeholder Title',
        'description': 'Placeholder Description'
    }
    
    return metadata