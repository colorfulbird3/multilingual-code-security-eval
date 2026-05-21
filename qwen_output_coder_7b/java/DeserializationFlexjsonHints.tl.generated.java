 ```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ConfigService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import flexjson.JSONDeserializer;

/**
 * Service for loading dynamic configuration from JSON strings.
 */
public class ConfigService {

    /**
     * Loads configuration from a JSON string and uses the Flexjson library
     * to deserialize it into a Java configuration object.
     *
     * @param jsonConfig the JSON-formatted string containing configuration data
     * @return the deserialized configuration object
     * @throws IllegalArgumentException if the input is null or empty
     * @throws RuntimeException if there is an error during JSON deserialization
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration string cannot be null or empty");
        }

        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON configuration: " + e.getMessage(), e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```