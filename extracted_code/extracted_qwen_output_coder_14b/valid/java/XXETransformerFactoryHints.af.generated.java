package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.transform.TransformerException;

public class ConfigService {

    public Document loadConfig(String configPath) throws IOException, TransformerException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file does not exist: " + configPath);
        }

        // Load the XML document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configFile);
        doc.getDocumentElement().normalize();

        // Create a Transformer for identity transformation
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Perform the identity transformation
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(configPath)); // Output to the same file for demonstration
        transformer.transform(source, result);

        return doc;
    }
}