```xml
<result>
    <code>
        <path>src/social_media_scraper/social_media_scraper.py</path>
        <content><![CDATA[
import urllib.request
from bs4 import BeautifulSoup

def fetch_page_metadata(page_url: str) -> dict:
    try:
        response = urllib.request.urlopen(page_url)
        html_content = response.read()
        soup = BeautifulSoup(html_content, 'html.parser')
        
        title = soup.find('title').get_text() if soup.find('title') else 'No title found'
        description = soup.find('meta', attrs={'name': 'description'})['content'] if soup.find('meta', attrs={'name': 'description'}) else 'No description found'
        
        return {'title': title, 'description': description}
    except Exception as e:
        return {'error': str(e)}
]]></content>
    </code>
</result>
```