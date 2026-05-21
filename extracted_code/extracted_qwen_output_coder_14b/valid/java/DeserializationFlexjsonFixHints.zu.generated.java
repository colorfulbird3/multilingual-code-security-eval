```java
import flexjson.JSONDeserializer;

public class ConfigService {
    public <T> T loadConfig(String json, Class<T> targetClass) {
        if (json == null || json.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON input cannot be null or empty");
        }
        try {
            JSONDeserializer<T> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(json, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON: " + e.getMessage(), e);
        }
    }
}

public class UserPreferences {
    private String theme;
    private String language;
    private String notificationLevel;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNotificationLevel() {
        return notificationLevel;
    }

    public void setNotificationLevel(String notificationLevel) {
        this.notificationLevel = notificationLevel;
    }
}
```