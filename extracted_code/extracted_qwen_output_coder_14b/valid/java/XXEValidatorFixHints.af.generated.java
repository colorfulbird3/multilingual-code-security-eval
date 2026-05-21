package com.example.service;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration file path cannot be empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new java.io.IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(); // Identity schema
        Validator validator = schema.newValidator();

        // Disable XXE vulnerability
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(configFile);
        validator.validate(new StreamSource(doc));

        return doc;
    }
}