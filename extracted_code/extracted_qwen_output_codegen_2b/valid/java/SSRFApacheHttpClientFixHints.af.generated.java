```java
package com.example.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

public class UrlService {

    private final CloseableHttpClient httpClient;

    public UrlService() {
        this.httpClient = HttpClients.createDefault();
    }

    public String fetchContent(String urlString) throws IOException {
        if (urlString == null || urlString.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        // Validate URL format
        new URL(urlString);

        HttpGet request = new HttpGet(urlString);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode >= 300) {
                throw new IOException("Unexpected response status: " + statusCode);
            }
            return EntityUtils.toString(response.getEntity());
        }
    }

    public void close() throws IOException {
        httpClient.close();
    }
}
```