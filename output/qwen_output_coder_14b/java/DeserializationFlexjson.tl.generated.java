```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ConfigService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.example.model.UserPreferences;
import flexjson.JSONDeserializer;

public class ConfigService {

    public Object loadConfig(String jsonConfig) {
        try {
            return new JSONDeserializer<UserPreferences>().deserialize(jsonConfig);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to deserialize JSON config", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```