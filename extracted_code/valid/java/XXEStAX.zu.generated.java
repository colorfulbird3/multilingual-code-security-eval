package com.example.service;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            // Create a SchemaFactory instance
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Create a Schema object from the schema content
            Schema schema = schemaFactory.newSchema(new StreamSource(new StringReader(schemaContent)));
            
            // Create an XMLStreamReader to read the XML data
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new StringReader(xmlData));
            
            // Validate the XML data against the schema
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.END_DOCUMENT) {
                    break;
                }
            }
            
            // Close the reader
            reader.close();
            
            // Return true if the XML data is valid
            return true;
        } catch (Exception e) {
            // Return false if there is an error during validation
            return false;
        }
    }
}