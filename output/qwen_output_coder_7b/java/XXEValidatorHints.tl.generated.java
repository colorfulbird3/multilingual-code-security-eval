```java
package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws IOException, SAXException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid or empty path");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("XML configuration file not found: " + configPath);
        }

        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("path/to/your/schema.xsd")); // Replace with your schema file path

        Validator validator = schema.newValidator();
        validator.validate(configFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(configFile);
    }

    public static void main(String[] args) {
        try {
            ConfigService service = new ConfigService();
            Document doc = service.loadConfig("path/to/your/config.xml"); // Replace with your config file path

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

This code defines a `ConfigService` class with a `loadConfig` method that takes a configuration file path as input and returns a `Document` object after validating the XML file using a provided schema. The `main` method demonstrates how to use this service to load and print the XML document.