package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        // Create a SchemaFactory instance for XML Schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Create a StreamSource from the schema content
        StreamSource schemaSource = new StreamSource(new StringReader(schemaContent));

        // Load the schema
        Schema schema = schemaFactory.newSchema(schemaSource);

        // Now you can use the schema to validate XML documents
        // For example:
        // Validator validator = schema.newValidator();
        // validator.validate(new StreamSource(new File("example.xml")));

        System.out.println("Schema loaded successfully.");
    }
}