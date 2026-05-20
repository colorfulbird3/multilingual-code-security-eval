package com.example.service;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        // Step 1: Check if the file exists and is not null or empty
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }
        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new FileNotFoundException("Config file not found at: " + configPath);
        }

        // Step 2: Create a SchemaFactory and load the schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("path/to/your/schema.xsd")); // Replace with your schema file path

        // Step 3: Create a Validator
        Validator validator = schema.newValidator();

        // Step 4: Validate the XML file
        try {
            validator.validate(new StreamSource(configFile));
        } catch (SAXException e) {
            throw new Exception("XML validation failed", e);
        }

        // Step 5: Parse the XML file into a DOM object
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(configFile);

        return document;
    }
}