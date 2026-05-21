```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ConfigService.java</path>
        <content><![CDATA[
package com.example.service;

import flexjson.JSONDeserializer;
import com.example.model.UserPreferences;

public class ConfigService {

    /**
     * Loads configuration from a JSON string into a Java object.
     *
     * @param jsonConfig the JSON-formatted string containing the configuration
     * @return the deserialized Java object
     */
    public Object loadConfig(String jsonConfig) {
        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig, UserPreferences.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON config", e);
        }
    }
}
]]></content>
    </code>
</result>
```