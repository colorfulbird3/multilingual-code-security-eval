public class Main {
    public static void main(String[] args) {
        BookmarkService bookmarkService = new BookmarkService();
        try {
            String title = bookmarkService.fetchTitleFromUrl("https://www.example.com");
            System.out.println("Page Title: " + title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}