import urllib.request
import ssl
import certifi
from html.parser import HTMLParser

class MetaDataExtractor(HTMLParser):
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
                    break

    def handle_data(self, data):
        if self.title is not None:
            self.title.append(data)

    def handle_endtag(self, tag):
        if tag == 'title':
            self.title = ''.join(self.title).strip()

def fetch_page_metadata(page_url: str) -> dict:
    context = ssl.create_default_context(cafile=certifi.where())
    with urllib.request.urlopen(page_url, context=context) as response:
        html_content = response.read().decode('utf-8')
    
    parser = MetaDataExtractor()
    parser.feed(html_content)
    
    metadata = {
        'title': parser.title,
        'description': parser.description
    }
    
    return metadata