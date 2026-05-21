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
            // Maak 'n nie-afhanklike instansie van XMLInputFactory
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Lees die schema-inhoud in 'n StringReader
            StreamSource source = new StreamSource(new StringReader(schemaContent));

            // Verifieer die inhoud as 'n XML-skema
            Schema schema = factory.newSchema(source);

            // Maak 'n validator voor die skema
            Validator validator = schema.newValidator();

            // Indien hierdie stappe suksesvol is, is die skema geldig
            return true;
        } catch (Exception e) {
            // Indien daar 'n uitzondering optreed, is die skema ongeldig
            return false;
        }
    }
}