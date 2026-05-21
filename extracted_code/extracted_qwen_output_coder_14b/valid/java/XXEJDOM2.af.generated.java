package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | NullPointerException e) {
            // Handle exceptions such as invalid XML format or missing elements
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return null;
    }
}