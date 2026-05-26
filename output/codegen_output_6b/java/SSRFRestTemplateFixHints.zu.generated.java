}

    /**
     * Landa okuqukethwe kwe-HTML kwekhasi elikule URL enikeziwe.
     * Le ndlela ihloselwe ukuthola idatha kwi-inthanethi yomphakathi.
     *
     * @param url I-URL egcwele yekhasi eliqondiwe, isb. "https://www.example.com"
     * @return Okuqukethwe kwe-HTML kwekhasi lewebhu njengomugqa. Ibuyisela null uma ikhasi lingenakufinyeleleka noma kwenzeka iphutha.
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
 *
 * @author Ivin Montero
 */
public class WebPageFetcherService {

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            System.err.println("Iphutha lokulanda okuqukethwe ku-URL: " + url + " - " + e.getMessage());
            return null;
        }
    }
}
