```java
import flexjson.JSONDeserializer;
import flexjson.JSONException;

public class ConfigService {
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration cannot be null or empty");
        }
        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Malformed JSON string: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during JSON deserialization", e);
        }
    }
}
```