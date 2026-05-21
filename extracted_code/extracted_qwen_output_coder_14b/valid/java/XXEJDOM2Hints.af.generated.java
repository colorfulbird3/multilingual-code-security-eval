package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new InputSource(new StringReader(xmlContent)));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (Exception e) {
            // Handle exceptions, log them, and return null
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return null;
    }
}