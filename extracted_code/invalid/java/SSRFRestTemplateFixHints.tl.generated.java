public String getPageContent(String url) {
    try {
        return restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
        System.err.println("Error sa pagkuha ng content mula sa URL: " + url + " - " + e.getMessage());
        return null;
    }
}