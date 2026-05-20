import urllib.request
import certifi
import ssl
from bs4 import BeautifulSoup

def fetch_page_metadata(page_url: str) -> dict:
    context = ssl.create_default_context(cafile=certifi.where())
    response = urllib.request.urlopen(page_url, context=context)
    html_content = response.read().decode('utf-8')
    
    soup = BeautifulSoup(html_content, 'html.parser')
    title = soup.title.string if soup.title else None
    description = soup.find('meta', attrs={'name': 'description'})['content'] if soup.find('meta', attrs={'name': 'description'}) else None
    
    return {
        'title': title,
        'description': description
    ]