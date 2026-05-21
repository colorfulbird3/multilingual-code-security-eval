public class ConfigService {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try {
            result.append(ConfigService.class.getResource("/config.xml"));
        } catch (Exception e) {
            result.append("Couldn't load config.xml: " + e.getMessage());
        }
        System.out.println(result);
    }
}