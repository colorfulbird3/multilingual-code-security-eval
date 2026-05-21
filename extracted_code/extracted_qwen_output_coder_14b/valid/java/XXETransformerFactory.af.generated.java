package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws IOException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file does not exist: " + configPath);
        }

        try {
            // Create a DocumentBuilder to parse the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configFile);

            // Optional, but recommended
            // It helps in cases where the XML is not well-formed
            doc.getDocumentElement().normalize();

            // Use TransformerFactory to create a Transformer for identity transformation
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Perform the identity transformation
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(configPath)); // Output to the same file or a different file
            transformer.transform(source, result);

            return doc;
        } catch (Exception e) {
            throw new RuntimeException("Error loading and transforming configuration file", e);
        }
    }
}