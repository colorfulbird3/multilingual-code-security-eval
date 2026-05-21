package com.app.service;

import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class XmlProcessingService {

    /**
     * Loads and parses an XML Schema from a string content using JAXP (SAX Parser).
     * This method validates the schema's format and prepares it for subsequent data validation.
     *
     * @param schemaContent A string containing the XML Schema (XSD) content.
     * @throws Exception If any error occurs during schema parsing or validation.
     */
    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty.");
        }

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);

            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(new InputSource(new StringReader(schemaContent)), new DefaultHandler() {
                @Override
                public void warning(SAXParseException e) {
                    System.out.println("Schema parsing warning: " + e.getMessage());
                }

                @Override
                public void error(SAXParseException e) throws SAXParseException {
                    throw new SAXParseException("Schema parsing error: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
                }

                @Override
                public void fatalError(SAXParseException e) throws SAXParseException {
                    throw new SAXParseException("Schema parsing fatal error: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
                }
            });

            System.out.println("XML Schema loaded and parsed successfully.");

        } catch (SAX