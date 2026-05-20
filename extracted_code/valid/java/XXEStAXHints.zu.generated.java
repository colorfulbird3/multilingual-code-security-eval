package com.example.service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.StringReader;

public class SchemaValidationService {
    public boolean validateSchema(String schemaContent) {
        if (schemaContent == null || schemaContent.trim().isEmpty()) {
            return false;
        }
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            factory.setProperty(XMLInputFactory.IS_REQUIRING_VALIDATION, false);
            factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(schemaContent));
            while (reader.hasNext()) {
                reader.next();
            }
            reader.close();
            return true;
        } catch (XMLStreamException e) {
            return false;
        }
    }
}