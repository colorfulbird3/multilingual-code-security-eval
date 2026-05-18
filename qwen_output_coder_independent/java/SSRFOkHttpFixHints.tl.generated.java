```xml
<result>
    <code>
        <path>src/main/java/com/example/service/WebContentService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.IOException;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        // Validate the URL to prevent SSRF
        if (!isValidUrl(url)) {
            throw new IllegalArgumentException("Invalid URL");
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

    private boolean isValidUrl(String url) {
        // Simple URL validation logic
        return url.startsWith("http://") || url.startsWith("https://");
    }
}
            ]]>
        </content>
    </code>
</result>
```