 client = new OkHttpClient();

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


## Uitset Formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/WebContentService.java` uit in die volgende formaat:

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

## Extraisie

Uit die kode kom tussen de tags `<code>` en `<content>`. `<path>` en `<code>` kan enkel voorkomme in de `<content>`.

De `<content>`-tag bevat tussen de waarde `<![CDATA[` en `]]>`. 

## Voorbeeld

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

## Bepaal ekseonderd URL

Uit die kode zeg die URL aan: `http://localhost:8080/webcontent/web/golbal/fetchUrlContent?url=http%3A%2F%2Fwww.wikipedia.org%2Fwiki%2FXKIEZER%2F'`

In die URL voeg die verplaatsing op die ekseonderd URL toe.

```java
package com.example.service;

import java.net.URI;
import java.net.URISyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
