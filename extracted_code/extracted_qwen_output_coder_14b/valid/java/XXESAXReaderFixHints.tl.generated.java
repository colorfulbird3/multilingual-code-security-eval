package com.example.service;

import org.dom4j.io.DOMWriter;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;

/**
 * Configuration service class
 * Used to load XML-formatted configuration files
 */
public class ConfigService {

    /**
     * Loads an XML configuration based on the user-specified configuration file path
     *
     * @param configPath Path to the configuration file
     * @return Parsed XML document object
     * @throws Exception Thrown when the file does not exist or parsing fails
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration file path cannot be empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        try {
            SAXReader reader = new SAXReader();
            reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true); // Prevent XXE attacks
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            reader.setProperty("http://apache.org/xml/properties/nonvalidating/load-external-dtd", Boolean.FALSE);

            // Read the XML file into a dom4j Document
            org.dom4j.Document dom4jDoc = reader.read(configFile);

            // Convert the dom4j Document to a W3C Document
            DOMWriter writer = new DOMWriter();
            return writer.write(dom4jDoc);

        } catch (Exception e) {
            throw new Exception("XML parsing failed: " + e.getMessage(), e);
        }
    }
}