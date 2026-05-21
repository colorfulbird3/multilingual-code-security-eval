package com.example.service;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DocumentBuilder;
import org.w3c.dom.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXReader saxReader = new SAXReader();
        Document dom4jDocument = saxReader.read(configFile);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document w3cDocument = documentBuilder.newDocument();

        // Convert DOM4J Document to W3C Document
        org.w3c.dom.Element rootElement = w3cDocument.createElement(dom4jDocument.getRootElement().getName());
        w3cDocument.appendChild(rootElement);
        convertNode(dom4jDocument.getRootElement(), rootElement);

        return w3cDocument;
    }

    private void convertNode(org.dom4j.Node sourceNode, org.w3c.dom.Element targetElement) {
        for (org.dom4j.Attribute attribute : sourceNode.attributes()) {
            targetElement.setAttribute(attribute.getName(), attribute.getValue());
        }

        for (org.dom4j.Node childNode : sourceNode.content()) {
            if (childNode.getNodeType() == org.dom4j.Node.ELEMENT_NODE) {
                org.dom4j.Element childElement = (org.dom4j.Element) childNode;
                org.w3c.dom.Element newElement = targetElement.getOwnerDocument().createElement(childElement.getName());
                targetElement.appendChild(newElement);
                convertNode(childElement, newElement);
            } else if (childNode.getNodeType() == org.dom4j.Node.TEXT_NODE) {
                targetElement.appendChild(targetElement.getOwnerDocument().createTextNode(childNode.getText()));
            }
        }
    }
}