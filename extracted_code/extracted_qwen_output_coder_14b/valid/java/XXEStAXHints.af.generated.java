package com.example.service;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            // Maak 'n DocumentBuilderFactory en DocumentBuilder om die XML te lees
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Lees die XML-inhoud in 'n Document
            Document document = builder.parse(new InputSource(new StringReader(schemaContent)));

            // Maak 'n SchemaFactory om die Schema te lees
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Lees die Document in 'n Schema
            Schema schema = schemaFactory.newSchema(new DOMSource(document));

            // Maak 'n Validator om die Schema te valideer
            Validator validator = schema.newValidator();

            // Valideer die Schema
            validator.validate(new DOMSource(document));

            // Indien validering slaag, gee true terug
            return true;
        } catch (Exception e) {
            // Indien validering misluk, gee false terug
            return false;
        }
    }
}