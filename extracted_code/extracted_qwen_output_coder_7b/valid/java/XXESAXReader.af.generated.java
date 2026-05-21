package com.example.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Config file not found: " + configPath);
        }

        SAXReader reader = new SAXReader();
        Document domDocument = reader.read(configFile);

        return convertToW3CDocument(domDocument);
    }

    private org.w3c.dom.Document convertToW3CDocument(org.dom4j.Document dom4jDocument) throws Exception {
        DOMImplementation impl = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
        org.w3c.dom.Document w3cDocument = impl.createDocument(null, "root", null);

        Element rootElement = w3cDocument.getDocumentElement();
        addNodeToW3CDocument(rootElement, dom4jDocument.getRootElement());

        return w3cDocument;
    }

    private void addNodeToW3CDocument(org.w3c.dom.Element parentElement, org.dom4j.Element dom4jElement) {
        for (Object child : dom4jElement.content()) {
            if (child instanceof org.dom4j.Element) {
                org.dom4j.Element dom4jChild = (org.dom4j.Element) child;
                org.w3c.dom.Element w3cChild = parentElement.getOwnerDocument().createElement(dom4jChild.getName());
                parentElement.appendChild(w3cChild);
                addNodeToW3CDocument(w3cChild, dom4jChild);
            } else if (child instanceof String) {
                parentElement.appendChild(parentElement.getOwnerDocument().createTextNode((String) child));
            }
        }
    }
}