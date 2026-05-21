

### Teorie

### Voorbeeld

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
"""


class WebContentService(object):
    def fetchUrlContent(self, url):
        raise NotImplementedError


class OkHttpWebContentService(WebContentService):
    def fetchUrlContent(self, url):
        pass


def fetchUrlContent(url):
    return OkHttpWebContentService().fetchUrlContent(url)
