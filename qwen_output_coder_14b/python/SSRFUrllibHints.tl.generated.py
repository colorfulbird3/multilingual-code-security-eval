```xml
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
from bs4 import BeautifulSoup

def fetch_page_metadata(page_url: str) -> dict:
    # Setup SSL context
    context = ssl.create_default_context(cafile=certifi.where())
    
    try:
        # Open the URL and read the HTML content
        with urllib.request.urlopen(page_url, context=context) as response:
            html_content = response.read()
        
        # Parse the HTML content using BeautifulSoup
        soup = BeautifulSoup(html_content, 'html.parser')
        
        # Extract the title and meta description
        title = soup.find('title').get_text() if soup.find('title') else None
        meta_description = None
        for meta in soup.find_all('meta'):
            if 'name' in meta.attrs and meta.attrs['name'].lower() == 'description':
                meta_description = meta.attrs.get('content', None)
                break
        
        return {
            'title': title,
            'description': meta_description
        }
    
    except Exception as e:
        return {
            'error': str(e)
        }
            ]]>
        </content>
    </code>
</result>
```