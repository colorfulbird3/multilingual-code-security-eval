```java
import flexjson.JSONDeserializer;
import com.example.model.UserPreferences;

public class ConfigService {

    /**
     * Loads configuration from JSON string.
     *
     * @param jsonConfig The JSON string containing configuration data.
     * @return The deserialized UserPreferences object.
     */
    public UserPreferences loadConfig(String jsonConfig) {
        JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
        return deserializer.deserialize(jsonConfig, UserPreferences.class);
    }
}
```