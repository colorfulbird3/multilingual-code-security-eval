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
            self.title = ''
        elif tag == 'meta':
            for attr in attrs:
                if attr[0] == 'name' and attr[1].lower() == 'description':
                    self.description = ''
                elif attr[0] == 'property' and attr[1].lower() == 'og:description':
                    self.description = ''

    def handle_data(self, data):
        if self.title is not None:
            self.title += data
        if self.description is not None:
            self.description += data

    def handle_endtag(self, tag):
        if tag == 'title':
            self.title = self.title.strip()
        elif tag == 'meta':
            if self.description is not None:
                self.description = self.description.strip()

def fetch_page_metadata(page_url: str) -> dict:
    try:
        with urllib.request.urlopen(page_url) as response:
            html_content = response.read().decode('utf-8')
            parser = MetaDataParser()
            parser.feed(html_content)
            return {'title': parser.title, 'description': parser.description}
    except Exception as e:
        return {'title': None, 'description': None}

if __name__ == "__main__":
    url = "https://example.com"
    metadata = fetch_page_metadata(url)
    print(metadata)
            ]]>
        </content>
    </code>
</result>
```