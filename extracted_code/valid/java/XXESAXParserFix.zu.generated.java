public class Main {
    public static void main(String[] args) {
        ConfigService configService = new ConfigService();
        try {
            Document doc = configService.loadConfig("path/to/config.xml");
            // Process the document as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}