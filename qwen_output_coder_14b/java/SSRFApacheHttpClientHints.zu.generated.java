Here's a Java implementation of the `UrlService` class with the `fetchUrlContent` method as described in the specification:

```java
package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class UrlService {

    public String fetchUrlContent(String userUrl) {
        // Check if the provided URL is valid
        if (userUrl == null || userUrl.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(userUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error fetching content from URL: " + userUrl, e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error closing response", e);
            }
        }
        return null;
    }
}
```

This implementation includes:
1. Checking if the provided URL is valid.
2. Using Apache HttpClient to make a GET request to the URL.
3. Retrieving the content from the response and returning it.
4. Handling exceptions and ensuring the response is closed properly.

To use this class, you would create an instance of `UrlService` and call the `fetchUrlContent` method with the desired URL as an argument. The method will return the content of the URL as a string.