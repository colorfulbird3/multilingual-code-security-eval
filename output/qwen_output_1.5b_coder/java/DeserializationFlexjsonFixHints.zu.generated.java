 ", language='" + language + '\'' +
                ", notificationLevel=" + notificationLevel +
                '}';
    }
}
```

- src/main/resources/config.json
```json
{
    "theme": "dark",
    "language": "en",
    "notificationLevel": 2
}
```

## Iziningo Kufanele I-Khodi

- Igama lephakheji: `src/test/java/com/example/service/ConfigServiceTest.java`
```java
package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigServiceTest {

    @Test
    public void testLoadConfig() throws Exception {
        ConfigService configService = new ConfigService();
        String jsonConfig = "{\"theme\":\"light\",\"language\":\"es\",\"notificationLevel\":3}";

        UserPreferences expected = new UserPreferences();
        expected.setTheme("light");
        expected.setLanguage("es");
        expected.setNotificationLevel(3);

        UserPreferences result = configService.loadConfig(jsonConfig);

        assertEquals(expected.toString(), result.toString());
    }
}
```

---

This Java code snippet demonstrates how to implement a configuration service using Flexjson for parsing JSON data and converting it into Java objects. The `ConfigService` class includes a method `loadConfig` that takes a JSON string as input and returns an object of type `UserPreferences`. The `UserPreferences` class represents the structure of the JSON data and is annotated with `@JsonDeserialize` from Flexjson to ensure proper deserialization. The test case in `ConfigServiceTest` verifies that the `loadConfig` method correctly parses the JSON and converts it into a `UserPreferences` object.