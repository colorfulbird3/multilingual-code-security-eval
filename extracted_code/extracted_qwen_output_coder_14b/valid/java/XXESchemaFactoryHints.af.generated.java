package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema schema;

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty");
        }

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try (StringReader reader = new StringReader(schemaContent)) {
            schema = factory.newSchema(new StreamSource(reader));
        }
    }

    public Schema getSchema() {
        return schema;
    }
}