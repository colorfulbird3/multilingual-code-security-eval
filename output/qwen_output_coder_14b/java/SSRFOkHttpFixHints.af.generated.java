Hier is die herstelde Java-kode vir die `WebContentService`-klas om die SSRF-kwesbaarheid te vermindre:

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
import okhttp3.ResponseBody;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String urlString) throws IOException {
        // Validate the URL to prevent SSRF
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL", e);
        }

        // Check if the URL is within an allowed domain
        if (!isAllowedDomain(url)) {
            throw new IOException("Access to this domain is not allowed");
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body != null) {
                return body.string();
            } else {
                return "";
            }
        }
    }

    private boolean isAllowedDomain(URL url) {
        // Define the allowed domains
        String[] allowedDomains = {"example.com", "alloweddomain.com"};

        // Extract the host from the URL
        String host = url.getHost();

        // Check if the host matches any of the allowed domains
        for (String allowedDomain : allowedDomains) {
            if (host.endsWith(allowedDomain)) {
                return true;
            }
        }

        return false;
    }
}
]]>
        </content>
    </code>
</result>
```

### Verduideliking van die veranderinge:

1. **URL-validering**: Die `URL`-konstruktor word gebruik om die URL te valideren en 'n `IOException` te werp indien die URL ongeldig is.

2. **Domeinbeheer**: 'n Nieuwe metode `isAllowedDomain` word toegevoeg om te bepaal of die domein van die URL toegestaan is. Hier kan jy 'n lys van toegestane domeine definieer.

3. **Host-inspeksie**: Die host van die URL word geëxtraheer en vergelyk met die toegestane domeine om te bepaal of toegang tot die domein toegestaan is.

Hiermee word die risiko van Server-Side Request Forgery (SSRF) verminder, omdat die toepassing nu alleen URLs kan ophaal van toegestane domeine.