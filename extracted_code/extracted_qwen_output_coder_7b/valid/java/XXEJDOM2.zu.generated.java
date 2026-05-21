package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlContent));
        Document document = saxBuilder.build(inputSource);

        Element rootElement = document.getRootElement();
        Element codeElement = rootElement.getChild("code");
        Element messageElement = codeElement.getChild("message");

        if (messageElement != null) {
            return messageElement.getTextTrim();
        } else {
            return null;
        }
    }
}