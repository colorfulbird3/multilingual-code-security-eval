>
    </code>
</result>
```
 */
public class WebPageFetcher {

    private final RestTemplate restTemplate;

    @Autowired
    public WebPageFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Kinukuha ang HTML na nilalaman ng pahina sa ibinigay na URL.
     * Ang pamamaraang ito ay para sa pagkuha ng datos mula sa pampublikong internet.
     *
     * @param url Ang buong URL ng target na webpage, hal. "https://www.example.com"
     * @return Ang HTML na nilalaman ng webpage bilang isang string. Nagbabalik ng null kung ang pahina ay hindi ma-access o may error.
     */
    public String getPageContent(String url) {
        try {
            // Kunin ang object mula sa tinukoy na URL, inaasahan ang isang string na response body.
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            // Sa isang tunay na aplikasyon, mas detalyadong pag-log ang ipapatupad dito.
            System.err.println("Error sa pagkuha ng content mula sa URL: " + url + " - " + e.getMessage());
            return null;
        }
    }
}
