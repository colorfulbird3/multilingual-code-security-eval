@Autowired
private WebPageFetcherService webPageFetcherService;

public void someMethod() {
    String url = "https://www.example.com";
    String htmlContent = webPageFetcherService.getPageContent(url);
    if (htmlContent != null) {
        // Process the HTML content
    } else {
        // Handle the case where the content could not be fetched
    }
}