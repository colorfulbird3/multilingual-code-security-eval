public class ConfigService extends Service {
    public Document loadConfig(String configPath) {
        try {
            return new SAXReader().read(new FileInputStream(configPath));
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while trying to load the config file", ex);
        }
    }
}