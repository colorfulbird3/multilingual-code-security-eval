package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IllegalArgumentException("Configuration file not found: " + configPath);
        }

        SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema();
        Validator validator = schema.newValidator();

        validator.validate(new StreamSource(configFile));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document = docBuilder.parse(configFile);

        return document;
    }
}