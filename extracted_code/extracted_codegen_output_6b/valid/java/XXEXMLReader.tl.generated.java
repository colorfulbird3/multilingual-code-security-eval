package com.app.service;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.isEmpty()) {
            throw new IllegalArgumentException("Schema content must not be null or empty");
        }

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setFeature("http://apache.org/xml/features/validation/schema", true);
        reader.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);

        InputSource inputSource = new InputSource(new java.io.StringReader(schemaContent));
        reader.parse(inputSource);
    }
}