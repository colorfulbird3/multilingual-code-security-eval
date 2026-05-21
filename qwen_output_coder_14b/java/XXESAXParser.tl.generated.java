Here is the complete code for the `ConfigService` class in Java:

```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        try {
            return saxParser.parse(new InputSource(configFile));
        } catch (Exception e) {
            throw new Exception("Invalid XML format", e);
        }
    }
}
```

This code defines a `ConfigService` class with a method `loadConfig` that takes a string representing the path to an XML configuration file. It uses the `SAXParserFactory` to create a `SAXParser`, which parses the XML file into a `Document` object. The method handles various exceptions such as invalid XML format, empty or null input paths, and file not found errors.