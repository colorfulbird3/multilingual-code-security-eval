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