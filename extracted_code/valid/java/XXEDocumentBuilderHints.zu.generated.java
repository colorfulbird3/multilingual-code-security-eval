```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(configPath));
            return document;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load XML config from: " + configPath, e);
        }
    }
}
```