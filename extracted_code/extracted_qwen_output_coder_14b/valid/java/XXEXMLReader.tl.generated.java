package com.app.service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser saxParser = factory.newSAXParser();

            // Parse the schema content using an InputSource
            InputSource inputSource = new InputSource(new StringReader(schemaContent));
            saxParser.getXMLReader().parse(inputSource);
        } catch (Exception e) {
            throw new Exception("Failed to load XML schema", e);
        }
    }
}