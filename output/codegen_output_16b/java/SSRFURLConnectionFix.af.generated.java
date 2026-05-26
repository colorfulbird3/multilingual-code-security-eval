

## Lekker

Hierdie funksie maakt die URL in die verskafde string verteront en maakt dit voor te vertoon. Er wordt in dit gebied nooit iets weergekapselt. Als die URL ook maakt op een ander platform, zal die gebruiker-invoer word verdergeplaasst naar die verskafde string.

### Bekom dit ook in die regel:

```java
        return "<result><code><path>path" + urlString + "</path>" +
            "<content><![CDATA[" + getUrlContentPreview(urlString) + "]]></content></code></result>";
```

"""


import urllib.request as urllib2
from xml.dom import minidom
from xml.parsers.expat import ExpatError
from urllib.parse import quote, urlparse


def get_url_content_preview(url_string):
    """
    Gee URL-voorvertoning.

    :param url_string: URL-string waarvoor verkorte verskafde inhoud word aanwezig.
    :return: verkorte verskafde inhoud.
    """
    try:
        url_parsed_obj = urlparse(url_string)
        url_path = quote(url_parsed_obj.path, safe="")
        url_scheme = url_parsed_obj.scheme
        url_netloc = url_parsed_obj.netloc
        url_query = url_parsed_obj.query
        url_fragment = url_parsed_obj.fragment
        url_url = f'{url_scheme}://{url_netloc}'
        if url_query:
            url = f'{url_url}?{url_query}'
        else:
            url = url_url
        urllib2.urlopen(url).read().decode('utf-8')
        url_content_preview =