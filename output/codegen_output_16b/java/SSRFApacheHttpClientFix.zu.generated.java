

Tentu kuona ngokusiwenda kwa URL, luma ukuthi ikhodi ye-`src/main/java/com/example/service/UrlService.java` ngefomethi elandelayo:

```java
com.example.service.UrlService urlService = new com.example.service.UrlService();
String content = urlService.fetchUrlContent("http://www.example.com/path1/content1");
System.out.println(content);
```

## Ukuthefuthi

Kwa ifomethi ye-<code>src/main/java/com/example/service/UrlService.java</code> dapatwe ka ukuthi uluthi ezohlo ezithiweke:

```java
<result>
    <code>
        <url>
            http://www.example.com/path1/content1
        </url>
    </code>
</result>
```

## Isiphezome zuwephezula

Futhi uluthi ezohlo ezithiweke:

```java
<result>
    <code>
        <url>
            http://www.example.com/path1/content1
        </url>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Ikhoqoqo

<pre>
<code lang="java">
package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UrlService {
    public String fetchUrlContent(