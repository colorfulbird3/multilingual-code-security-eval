package com.app.service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.StringReader;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty");
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(new InputSource(new StringReader(schemaContent)), new DefaultHandler() {
            @Override
            public void warning(SAXParseException e) throws SAXException {
                System.out.println("Warning: " + e.getMessage());
            }

            @Override
            public void error(SAXParseException e) throws SAXException {
                throw e;
            }

            @Override
            public void fatalError(SAXParseException e) throws SAXException {
                throw e;
            }
        });

        System.out.println("Schema loaded and validated successfully.");
    }
}