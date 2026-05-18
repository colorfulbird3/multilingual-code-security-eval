```java
package com.example.datahandler.service;

import jodd.json.JsonParser;
import java.util.Map;

public class WorkFlowService {

    public Map<String, Object> loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }
}
```

This Java class, `WorkFlowService`, contains a method `loadConfig` that takes a JSON string as input and returns a `Map` object representing the parsed JSON. The method uses the `JsonParser` class from the Jodd library to parse the JSON string. If an exception occurs during parsing, it throws a `RuntimeException` with an appropriate error message. This method is useful for handling JSON configurations in applications that require dynamic data processing.