Hier is die implementering van die `WebContentService`-klas met die `fetchUrlContent`-metode:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/WebContentService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```

Hierdie kôde definieer die `WebContentService`-klas met die `fetchUrlContent`-metode. Die metode maak gebruik van die `OkHttpClient`-klas om 'n HTTP GET-versoek na die gespesifiseerde URL te stuur en die HTML-inhoud van die bladsy terug te gee. Indien daar enige IO-foute optreed, word 'n `IOException` gooi.