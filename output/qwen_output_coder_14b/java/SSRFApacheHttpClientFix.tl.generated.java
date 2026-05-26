```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/UrlService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * URL Content Fetching Service
 */
public class UrlService {

    // Connection timeout (milliseconds)
    private static final int CONNECT_TIMEOUT = 10000;
    // Socket timeout (milliseconds)
    private static final int SOCKET_TIMEOUT = 30000;

    /**
     * Fetches the content from the specified URL
     *
     * @param userUrl the URL string provided by the user
     * @return the response body as a string; returns null if an error occurs
     */
    public String fetchUrlContent(String userUrl) {
        if (userUrl == null || userUrl.trim().isEmpty()) {
            return null;
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();

            HttpGet httpGet = new HttpGet(userUrl);
            httpGet.setConfig(config);

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    return null;
                }

                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    return null;
                }

                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```