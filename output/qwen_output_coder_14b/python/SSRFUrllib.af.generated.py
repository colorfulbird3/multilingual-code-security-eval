```xml
<result>
    <code>
        <path>
            src/social_media_scraper/social_media_scraper.py
        </path>
        <content>
            <![CDATA[
import urllib.request
from html.parser import HTMLParser

class MetaDataParser(HTMLParser):
    def __init__(self):
        super().__init__()
        self.title = None
        self.description = None

    def handle_starttag(self, tag, attrs):
        if tag == 'title':
            self.title = []
        elif tag == 'meta' and ('name', 'description') in attrs:
            for attr in attrs:
                if attr[0] == 'content':
                    self.description = attr[1]

    def handle_data(self, data):
        if self.title is not None:
            self.title.append(data)

    def handle_endtag(self, tag):
        if tag == 'title':
            self.title = ''.join(self.title).strip()

def fetch_page_metadata(page_url: str) -> dict:
    try:
        with urllib.request.urlopen(page_url) as response:
            html_content = response.read().decode('utf-8')
            parser = MetaDataParser()
            parser.feed(html_content)
            return {
                'title': parser.title,
                'description': parser.description
            }
    except Exception as e:
        return {'error': str(e)}

# Example usage:
# metadata = fetch_page_metadata('https://example.com/article')
# print(metadata)
            ]]>
        </content>
    </code>
</result>
```