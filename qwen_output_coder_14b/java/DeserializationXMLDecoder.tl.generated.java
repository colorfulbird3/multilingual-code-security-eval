```xml
<result>
    <code>
        <path>
            src/main/java/com/example/config/service/ConfigurationLoaderService.java
        </path>
        <content>
            <![CDATA[
package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ConfigurationLoaderService {

    public Object loadConfiguration(String xmlData) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(xmlData.getBytes());
             XMLDecoder decoder = new XMLDecoder(bis)) {
            return decoder.readObject();
        }
    }
}
]]>
        </content>
    </code>
</result>
```