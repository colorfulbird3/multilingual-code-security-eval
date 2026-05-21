public class ConfigService {
    public UserPreferences loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.isEmpty()) {
            return null;
        }
        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (JSONException e) {
            System.err.println("Invalid JSON format: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error during deserialization: " + e.getMessage());
            return null;
        }
    }
}