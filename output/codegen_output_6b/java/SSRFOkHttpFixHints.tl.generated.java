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


## Sample Code

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

## Java Code

```java
package com.example.service;

import java.io.IOException;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
               .url(url)
               .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body!= null) {
                return body.string();
            } else {
                return "";
            }
        }
    }
}
```
`
## Python Code

```python
from okhttp3 import OkHttpClient

from xml.etree.ElementTree import XML

class WebContentService:
    def __init__(self):
        self.__http_client = OkHttpClient()

    def fetch_url_content(self, url):
        response = self.__http_client.request(
            Request(url = url)
        )

        content = XML(response.content.decode())

        return content.find("code").text, content.find("content").text
```
`
## PHP Code

```php
<?php

$client = new \Oskari\service\OkHttpClient();

function fetchUrlContent($url) {
    $response = $client->request($url);
    $content = strip_tags($response->content);
    return $content;
}
```
`
## JavaScript Code

```javascript
var WebContentService = function() {
    var client = new Oskari.service.OkHttpClient();
    return {
        fetchUrlContent: function(url