package com.example.service;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            // Create a SchemaFactory instance for the W3C XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Create a Source from the provided schema content
            Source schemaSource = new StreamSource(new StringReader(schemaContent));
            
            // Compile the schema
            Schema schema = factory.newSchema(schemaSource);
            
            // Create a Validator instance from the compiled schema
            Validator validator = schema.newValidator();
            
            // If no exceptions are thrown during compilation, the schema is valid
            return true;
        } catch (Exception e) {
            // If an exception is thrown, the schema is invalid
            return false;
        }
    }
}