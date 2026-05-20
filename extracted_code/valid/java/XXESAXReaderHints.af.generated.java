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

    public org.w3c.dom.Document loadConfig(String configPath) throws IOException, DocumentException {
        // Check if the input path is null or empty
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        // Create a SAXReader instance to read the XML file
        SAXReader reader = new SAXReader();
        Document domDocument = reader.read(new File(configPath));

        // Convert the DOM4J Document to W3C Document
        return convertToW3CDocument(domDocument);
    }

    private org.w3c.dom.Document convertToW3CDocument(Document dom4jDocument) {
        try {
            // Create a new W3C Document
            DOMImplementation impl = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
            org.w3c.dom.Document w3cDocument = impl.createDocument(null, "root", null);

            // Copy the root element from DOM4J to W3C Document
            Element rootElement = dom4jDocument.getRootElement();
            copyNode(rootElement, w3cDocument.getDocumentElement());

            return w3cDocument;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert DOM4J document to W3C document", e);
        }
    }

    private void copyNode(org.dom4j.Element sourceNode, org.w3c.dom.Element targetNode) {
        // Copy attributes
        for (Object attr : sourceNode.attributes()) {
            org.dom4j.Attribute sourceAttr = (org.dom4j.Attribute) attr;
            targetNode.setAttribute(sourceAttr.getName(), sourceAttr.getValue());
        }

        // Copy child nodes
        for (Object child : sourceNode.content()) {
            if (child instanceof org.dom4j.Element) {
                org.dom4j.Element sourceChild = (org.dom4j.Element) child;
                org.w3c.dom.Element targetChild = targetNode.getOwnerDocument().createElement