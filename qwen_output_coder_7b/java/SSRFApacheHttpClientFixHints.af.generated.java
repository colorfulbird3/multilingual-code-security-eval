```xml
<result>
    <code>
        <path>src/main/java/com/example/service/UrlService.java</path>
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
     * @return the response body as a string, or null if an error occurs
     */
    public String fetchUrlContent(String userUrl) {
        if (userUrl == null || userUrl.trim().isEmpty()) {
            return null;
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClients.createDefault();

            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();

            HttpGet httpGet = new HttpGet(userUrl);
            httpGet.setConfig(config);

            response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }

            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }

            String content = EntityUtils.toString(entity, "UTF-8");
            return content;

        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```