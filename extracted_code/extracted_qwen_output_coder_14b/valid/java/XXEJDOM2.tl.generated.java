package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.StringReader;

public class XmlDataParser {
    public String parse(String xmlContent) throws Exception {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | NullPointerException e) {
            // Log the exception details if necessary
        }
        return null;
    }
}