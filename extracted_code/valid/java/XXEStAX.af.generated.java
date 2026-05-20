package com.example.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            // Create a SchemaFactory for XML Schema
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Create a StreamSource from the schema content
            StreamSource schemaSource = new StreamSource(new StringReader(schemaContent));
            
            // Compile the schema
            Schema schema = schemaFactory.newSchema(schemaSource);
            
            // Create a Validator for the schema
            Validator validator = schema.newValidator();
            
            // Validate the schema content
            validator.validate(schemaSource);
            
            return true; // Validation successful
        } catch (Exception e) {
            // Validation failed or an exception occurred
            return false;
        }
    }
}