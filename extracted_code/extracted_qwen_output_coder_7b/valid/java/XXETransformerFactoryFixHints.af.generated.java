package com.example.service;

import org.w3c.dom.Document;
import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Configuration service class
 * Used to load and standardize XML-formatted configuration files
 */
public class ConfigService {

    /**
     * Loads an XML configuration from the user-specified file path and performs identity transformation.
     *
     * @param configPath Path to the configuration file
     * @return The standardized XML document object
     * @throws Exception Thrown when the file does not exist or transformation fails
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration file path cannot be empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new java.io.IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        // Disable XXE processing
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        TransformerFactory factory = TransformerFactory.newInstance();

        // Create an identity transformer
        Transformer transformer = factory.newTransformer();

        StreamSource source = new StreamSource(configFile);
        DOMResult result = new DOMResult();

        transformer.transform(source, result);

        return (Document) result.getNode();
    }
}