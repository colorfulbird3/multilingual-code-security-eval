```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ConfigService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import flexjson.JSONDeserializer;
import com.example.model.UserPreferences;

public class ConfigService {

    /**
     * Laai 'n JSON-geformateerde string as 'n Java-konfigurasieobjek.
     *
     * @param jsonConfig die JSON-geformateerde string om te laai
     * @return 'n Java-konfigurasieobjek
     */
    public Object loadConfig(String jsonConfig) {
        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig, UserPreferences.class);
        } catch (Exception e) {
            throw new RuntimeException("Kon nie die JSON-configuratie laai nie", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```