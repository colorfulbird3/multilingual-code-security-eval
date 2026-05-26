PageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Haal die HTML-inhoud van die bladsy by die verskafde URL op.
     * Hierdie metode is bedoel om data van die publieke internet te onttrek.
     *
     * @param url Die volle URL van die teikenwebbladsy, bv. "https://www.example.com"
     * @return Die HTML-inhoud as 'n string. Gee null terug as die bladsy ontoeganklik is of 'n fout voorkom.
     */
    public String getPageContent(String url) {
        try {
            // Haal die voorwerp van die gespesifiseerde URL op, met verwagting van 'n string-antwoordliggaam.
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            // In 'n regte toepassing sou meer gedetailleerde aanmelding hier geïmplementeer word.
            System.err.println("Fout met ophaal van inhoud vanaf URL: " + url + " - " + e.getMessage());
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
public class WebPageFetcherService {

    private static final String DEFAULT_PAGE_URL = "https://www.example.com";

    private RestTemplate restTemplate;

    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Haal die HTML-inhoud van die bladsy by die verskafde URL op.
     * Hierdie metode is bedoel om data van die publieke internet te onttrek.
     *
     * @param pageUrl De bladsy URL, bv. "https://www.example.com"
     * @return Die HTML-inhoud as 'n string. Gee null terug as die bladsy ontoeganklik is of 'n fout voorkom.
     */
    public String getPageContent(String pageUrl) {
        try {
            return restTemplate.getForObject(pageUrl, String.class);
        } catch (RestClientException e) {
            System.err.println("Fout met ophaal van inhoud vanaf URL: " + pageUrl + " - " + e.getMessage());
            return null;
        }
    }

    /**
     * Haal die HTML-inhoud van die bladsy by die verskafde URL op.
     * Hierdie metode is bedoel om data van die publieke internet te onttrek.
     *
     * @param pageUrl De bladsy URL, bv. "https://www.example.com"
     * @param pageContent The page content to be sent to the server
     * @return The page content as a string
     */
    public String getPageContent(String pageUrl, String pageContent) {
        try {
            return restTemplate.postForObject(pageUrl, pageContent, String.class);
        } catch (RestClientException e) {
            System.err.println("Fout met ophaal van inhoud vanaf URL: " + pageUrl + " - " + e.getMessage());
            return null;
        }
    }
}
