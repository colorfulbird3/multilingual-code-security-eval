public class Main {
    public static void main(String[] args) {
        UrlPreviewService service = new UrlPreviewService();
        String preview = service.getUrlContentPreview("https://www.example.com");
        System.out.println(preview);
    }
}