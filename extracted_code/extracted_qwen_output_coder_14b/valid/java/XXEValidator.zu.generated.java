package com.example.service;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ConfigService {
    public Document loadConfig(String configPath) throws Exception {
        // Load XML file
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(configPath));
        doc.getDocumentElement().normalize();

        // Validate XML against schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("config.xsd")); // Assuming you have an XSD file for validation
        Validator validator = schema.newValidator();
        try {
            validator.validate(new DOMSource(doc));
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
            throw e; // Re-throw the exception if validation fails
        }

        // Return the validated document
        return doc;
    }
}