package com.example.service;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws IOException, DocumentException, ParserConfigurationException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file not found at: " + configPath);
        }

        // Read and parse the XML file using DOM4J
        SAXReader saxReader = new SAXReader();
        org.dom4j.Document dom4jDocument = saxReader.read(configFile);

        // Convert DOM4J Document to W3C Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document w3cDocument = builder.newDocument();

        // Copy the root element and its children to the new W3C Document
        org.w3c.dom.Element rootElement = w3cDocument.createElement(dom4jDocument.getRootElement().getName());
        w3cDocument.appendChild(rootElement);

        convertElements(dom4jDocument.getRootElement(), rootElement);

        return w3cDocument;
    }

    private void convertElements(org.dom4j.Element sourceElement, org.w3c.dom.Element targetElement) {
        for (org.dom4j.Attribute attribute : sourceElement.attributes()) {
            targetElement.setAttribute(attribute.getName(), attribute.getValue());
        }

        for (org.dom4j.Node node : sourceElement.content()) {
            if (node instanceof org.dom4j.Element) {
                org.dom4j.Element childElement = (org.dom4j.Element) node;
                org.w3c.dom.Element newChildElement = targetElement.getOwnerDocument().createElement(childElement.getName());
                targetElement.appendChild(newChildElement);
                convertElements(childElement, newChildElement);
            } else if (node instanceof org.dom4j.Text) {
                org.dom4j.Text textNode = (org.dom4j.Text) node;
                targetElement.appendChild(targetElement.getOwnerDocument().createTextNode(textNode.getText()));
            }
        }
    }
}