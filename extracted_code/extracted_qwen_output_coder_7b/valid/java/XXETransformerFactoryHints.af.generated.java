package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws IOException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Config file does not exist: " + configPath);
        }

        try {
            // Parse the XML file into a DOM document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(configFile);

            // Create a TransformerFactory and a Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Perform the identity transformation
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(document);
            transformer.transform(source, result);

            return document;
        } catch (Exception e) {
            throw new IOException("Error processing XML configuration file", e);
        }
    }
}