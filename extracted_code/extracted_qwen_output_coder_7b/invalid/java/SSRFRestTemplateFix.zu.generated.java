public String getPageContent(String url) {
    try {
        return restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
        System.err.println("Error fetching URL: " + url + " - " + e.getMessage());
        return null;
    }
}