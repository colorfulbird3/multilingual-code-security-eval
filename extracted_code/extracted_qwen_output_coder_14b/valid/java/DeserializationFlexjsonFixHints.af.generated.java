public class Main {
    public static void main(String[] args) {
        ConfigService configService = new ConfigService();
        
        String jsonConfig = "{\"key\":\"value\"}";
        try {
            Object configObject = configService.loadConfig(jsonConfig);
            System.out.println("Config loaded successfully: " + configObject);
        } catch (IllegalArgumentException | RuntimeException e) {
            System.err.println("Error loading config: " + e.getMessage());
        }
    }
}