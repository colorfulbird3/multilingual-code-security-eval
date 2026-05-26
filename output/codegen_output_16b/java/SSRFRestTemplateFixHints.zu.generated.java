-HTML kwekhasi lewebhu njengomugqa. Ibuyisela null uma ikhasi lingenakufinyeleleka noma kwenzeka iphutha.
     */
    public String getPageContent(String url) {
        try {
            // Landa into kusukela ku-URL enikeziwe, ulindele umzimba wempendulo oyintambo.
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            // Kusicelo sangempela, ukuloga okuningiliziwe kungasetshenziswa lapha.
            System.err.println("Iphutha lokulanda okuqukethwe ku-URL: " + url + " - " + e.getMessage());
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```

*/
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public class WebPageFetcherService {

    private final RestTemplate restTemplate;

    @Autowired
    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void fetch() {
        System.out.println("Fetching page: https://www.example.com");
        String pageContent = restTemplate.getForObject("https://www.example.com", String.class);
        System.out.println("Page content: " + pageContent);
    }
}
