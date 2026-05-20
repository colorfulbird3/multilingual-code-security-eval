package com.app.service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.io.StringReader;
import java.util.logging.Logger;

public class XmlProcessingService {
    private static final Logger logger = Logger.getLogger(XmlProcessingService.class.getName());

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty");
        }

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            parser.parse(new InputSource(new StringReader(schemaContent)), new DefaultHandler() {
                @Override
                public void warning(org.xml.sax.SAXParseException e) {
                    logger.warning("Warning: " + e.getMessage());
                }

                @Override
                public void error(org.xml.sax.SAXParseException e) {
                    logger.severe("Error: " + e.getMessage());
                }

                @Override
                public void fatalError(org.xml.sax.SAXParseException e) {
                    logger.severe("Fatal Error: " + e.getMessage());
                }
            });
        } catch (SAXParseException e) {
            throw new Exception("XML parsing error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception("Error loading schema: " + e.getMessage(), e);
        }
    }
}