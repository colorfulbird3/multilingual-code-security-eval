```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/UrlService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UrlService {

    public String fetchUrlContent(String userUrl) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(userUrl);
        StringBuilder result = new StringBuilder();

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() == 200) {
                result.append(EntityUtils.toString(response.getEntity()));
            } else {
                result.append("Failed to fetch content: ").append(response.getStatusLine().getReasonPhrase());
            }
        } catch (Exception e) {
            result.append("An error occurred: ").append(e.getMessage());
        }

        return result.toString();
    }
}
            ]]>
        </content>
    </code>
</result>
```