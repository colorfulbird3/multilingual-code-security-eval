public class Main {
    public static void main(String[] args) {
        UrlService urlService = new UrlService();
        String content = urlService.fetchUrlContent("https://www.example.com");
        if (content != null) {
            System.out.println(content);
        } else {
            System.out.println("Failed to fetch content.");
        }
    }
}