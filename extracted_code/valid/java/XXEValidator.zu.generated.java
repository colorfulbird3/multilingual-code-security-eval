```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        // Create a SchemaFactory for XML Schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
        // Create a Validator instance (without schema, just for well-formedness)
        Validator validator = schemaFactory.newSchema().newValidator();
        
        // Validate the XML file
        validator.validate(new StreamSource(new File(configPath)));
        
        // Parse the XML file into a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(configPath));
        
        return document;
    }
}
```