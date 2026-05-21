package com.example.service;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.io.IOException;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            // Maak 'n nieuw SchemaFactory-objek
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            // Parse die XML-string na 'n Schema-objek
            Schema schema = factory.newSchema(new InputSource(new StringReader(schemaContent)));

            // Maak 'n Validator-objek uit die Schema
            Validator validator = schema.newValidator();

            // Valider die XML-string
            validator.validate(new InputSource(new StringReader(schemaContent)));

            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}