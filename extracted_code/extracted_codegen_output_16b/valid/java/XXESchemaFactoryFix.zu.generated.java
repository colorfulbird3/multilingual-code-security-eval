package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

/**
 * A service for processing and validating XML-based data.
 */
public class XmlProcessingService {

    /**
     * Creates a Schema object from a string containing the XML Schema Definition (XSD).
     * This schema can then be used to validate XML documents.
     *
     * @param schemaContent The content of the XML Schema.
     * @throws Exception if the schema content is malformed or cannot be processed.
     */
    public Schema createSchema(String schemaContent) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        StreamSource source = new StreamSource(new StringReader(schemaContent));
        return factory.newSchema(source);
    }
}