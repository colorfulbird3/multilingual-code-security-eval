package com.example.service;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("Configuration file not found at: " + configPath);
        }

        SAXReader saxReader = new SAXReader();
        Document dom4jDocument = saxReader.read(configFile);

        // Convert dom4j Document to w3c Document
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementation implementation = registry.getDOMImplementation();
        DocumentType doctype = implementation.createDocumentType("html", "-//W3C//DTD HTML 4.0 Transitional//EN", "http://www.w3.org/TR/REC-html40/loose.dtd");
        org.w3c.dom.Document w3cDocument = implementation.createDocument(null, "html", doctype);

        Element rootElement = w3cDocument.getDocumentElement();
        convert(dom4jDocument.getRootElement(), rootElement);

        return w3cDocument;
    }

    private void convert(org.dom4j.Element dom4jElement, Element w3cElement) {
        for (org.dom4j.Attribute attribute : dom4jElement.attributes()) {
            w3cElement.setAttribute(attribute.getName(), attribute.getValue());
        }

        for (org.dom4j.Element child : dom4jElement.elements()) {
            Element newChild = w3cElement.getOwnerDocument().createElement(child.getName());
            w3cElement.appendChild(newChild);
            convert(child, newChild);
        }

        w3cElement.setTextContent(dom4jElement.getTextTrim());
    }
}