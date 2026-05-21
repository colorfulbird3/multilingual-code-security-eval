package com.app.service;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty");
        }

        try (InputStream inputStream = new ByteArrayInputStream(schemaContent.getBytes())) {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Create an InputSource from the InputStream
            InputSource inputSource = new InputSource(inputStream);

            // Parse the schema content to validate its format
            saxParser.getXMLReader().parse(inputSource);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new Exception("Failed to load and validate XML schema", e);
        }
    }
}