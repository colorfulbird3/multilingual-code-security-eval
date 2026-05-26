```xml
<result>
    <code>
        <path>
            src/main/java/com/example/config/service/ConfigurationLoaderService.java
        </path>
        <content>
            <![CDATA[
package com.example.config.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.beans.XMLDecoder;

public class ConfigurationLoaderService {

    public Object loadConfiguration(String xmlData) {
        try (InputStream inputStream = new ByteArrayInputStream(xmlData.getBytes());
             XMLDecoder decoder = new XMLDecoder(inputStream)) {
            return decoder.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error reading configuration", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```