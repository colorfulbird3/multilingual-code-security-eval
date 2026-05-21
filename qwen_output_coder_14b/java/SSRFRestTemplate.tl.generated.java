```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/WebPageFetcherService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch page content", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```