public String getPageContent(String url) {
    try {
        return restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
        System.err.println("Fout met die haal van inhoud vanaf URL: " + url + " - " + e.getMessage());
        return null;
    }
}