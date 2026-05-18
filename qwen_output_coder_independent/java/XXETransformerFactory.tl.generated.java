```java
package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;

public class ConfigService {
    public Document loadConfig(String configPath) throws IOException, TransformerException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file does not exist: " + configPath);
        }

        try {
            // Parse the XML file into a DOM document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(configFile);

            // Create a transformer for identity transform
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Perform the identity transform
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(document);
            transformer.transform(source, result);

            return document;
        } catch (Exception e) {
            throw new TransformerException("Error during XML transformation", e);
        }
    }
}
```