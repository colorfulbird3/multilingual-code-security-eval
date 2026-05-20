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