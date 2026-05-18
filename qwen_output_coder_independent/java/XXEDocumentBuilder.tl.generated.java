```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: configPath cannot be null or empty");
        }

        File inputFile = new File(configPath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new IOException("Invalid input: configPath does not point to a valid file");
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            return dBuilder.parse(inputFile);
        } catch (Exception e) {
            throw new Exception("Failed to parse XML file", e);
        }
    }
}
```

This code defines a `ConfigService` class with a method `loadConfig` that takes a file path as input and returns a `Document` object representing the parsed XML content. The method uses `DocumentBuilderFactory` and `DocumentBuilder` from the JAXP library to parse the XML file. It also includes basic validation for the input file path and throws exceptions for invalid inputs or parsing errors.