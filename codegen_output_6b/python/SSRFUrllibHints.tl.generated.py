ahinaan:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## sample code

```python
from gumawa.social_media_scraper import social_media_scraper

def fetch_page_metadata(page_url: str) -> dict:
    response = social_media_scraper.fetch_page_metadata(page_url)
    return response
```

## examples

```python
import gumawa.social_media_scraper as social_media_scraper

def fetch_page_metadata(page_url: str) -> dict:
    response = social_media_scraper.fetch_page_metadata(page_url)
    return response
```

## input and output

```
# input
page_url = "https://github.com/kawabung"

# output
{
    "code": {
        "path": "github.com/kawabung",
        "content": {
            "![CDATA[\n"
            "github.com/\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|_______________________________\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|\n"
            "|_______________________________\n"
            "\\_/\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            "\n"
            