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
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("Config file not found: " + configPath);
        }

        // Create a SchemaFactory to create a Schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("path/to/your/schema.xsd")); // Replace with your schema file path

        // Create a Validator to validate the XML document
        Validator validator = schema.newValidator();

        // Parse the XML file into a Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configFile);

        // Validate the document
        try {
            validator.validate(new DOMSource(doc));
        } catch (SAXException e) {
            throw new SAXException("XML validation failed: " + e.getMessage());
        }

        return doc;
    }
}