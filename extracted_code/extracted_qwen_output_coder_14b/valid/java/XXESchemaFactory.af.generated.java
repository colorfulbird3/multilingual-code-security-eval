package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema schema;

    public void loadSchema(String schemaContent) throws Exception {
        try {
            // Create a SchemaFactory instance for the W3C XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Create a Source object from the schema content
            Source schemaSource = new StreamSource(new StringReader(schemaContent));

            // Compile the schema
            this.schema = factory.newSchema(schemaSource);
        } catch (Exception e) {
            throw new Exception("Failed to load schema", e);
        }
    }

    public Schema getSchema() {
        return schema;
    }
}