package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("Config file not found at: " + configPath);
        }

        // Create a SchemaFactory and load the XML schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema(new StreamSource(ConfigService.class.getResourceAsStream("/config.xsd")));

        // Create a Validator instance
        Validator validator = schema.newValidator();

        // Validate the XML file
        try {
            validator.validate(new StreamSource(configFile));
        } catch (Exception e) {
            throw new Exception("XML validation failed: " + e.getMessage());
        }

        // Parse the XML file into a Document object
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document = docBuilder.parse(configFile);

        return document;
    }
}