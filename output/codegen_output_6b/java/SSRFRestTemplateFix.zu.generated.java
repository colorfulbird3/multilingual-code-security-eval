
 */
public class WebPageFetcherService {
    private final RestTemplate restTemplate;

    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Ithola okuqukethwe kwe-HTML kwekhasi elikuleli URL elinikeziwe.
     * Le ndlela ihloselwe ukuthola idatha ku-inthanethi yomphakathi.
     *
     * @param url I-URL egcwele yekhasi eliqondiwe, isb., "https://www.example.com"
     * @return Okuqukethwe kwe-HTML njengomugqa. Ibuya null uma ikhasi lingafinyeleleki noma kwenzeka iphutha.
     */
    public String getPageContent(String url) {
        try {
            // Thola into evela ku-URL ecacisiwe, ulindele umugqa wempendulo.
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            // Ohlelweni lwangempela, ukugcinwa kwemibhalo okuningiliziwe kungaqaliswa lapha.
            System.err.println("Iphutha lokuthola okuqukethwe ku-URL: " + url + " - " + e.getMessage());
            return null;
        }
    }
}
