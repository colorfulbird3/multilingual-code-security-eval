public String getPageContent(URL url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            System.err.println("Iphutha lokuthola okuqukethwe ku-URL: " + url + " - " + e.getMessage());
            return null;
        }
    }

    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            System.err.println("Iphutha lokuthola okuqukethwe ku-URL: " + url + " - " + e.getMessage());
            return null;
        }
    }