package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file does not exist at: " + configPath);
        }

        // Create a SchemaFactory capable of understanding W3C XML Schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        try {
            // Load the schema from an XSD file (assuming you have one)
            Schema schema = schemaFactory.newSchema(new File("path/to/your/schema.xsd"));

            // Create a Validator instance for this schema
            Validator validator = schema.newValidator();

            // Validate the XML file
            validator.validate(new StreamSource(configFile));

        } catch (SAXException e) {
            throw new Exception("XML validation failed: " + e.getMessage(), e);
        }

        // If validation is successful, parse the XML file into a Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(configFile);
    }
}