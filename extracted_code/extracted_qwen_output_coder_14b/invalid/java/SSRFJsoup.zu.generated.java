public String fetchTitleFromUrl(String urlString) {
    try {
        Document doc = Jsoup.connect(urlString).get();
        return doc.title();
    } catch (IOException e) {
        return "Error fetching title: " + e.getMessage();
    }
}