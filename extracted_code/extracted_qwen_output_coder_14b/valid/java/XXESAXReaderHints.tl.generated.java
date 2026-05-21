package com.example.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) throws IOException, DocumentException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Configuration path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXReader reader = new SAXReader();
        Document dom4jDocument = reader.read(configFile);

        return convertToW3CDocument(dom4jDocument);
    }

    private org.w3c.dom.Document convertToW3CDocument(Document dom4jDocument) throws DocumentException {
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementation impl = registry.getDOMImplementation();
        String namespaceURI = dom4jDocument.getDocumentElement().getNamespaceURI();
        String qualifiedName = dom4jDocument.getDocumentElement().getName();
        DocumentType docType = impl.createDocumentType(qualifiedName, "", "");
        org.w3c.dom.Document w3cDocument = impl.createDocument(namespaceURI, qualifiedName, docType);

        Element rootElement = w3cDocument.getDocumentElement();
        copyNode(dom4jDocument.getDocumentElement(), rootElement);

        return w3cDocument;
    }

    private void copyNode(org.dom4j.Node node, Element parent) {
        for (org.dom4j.Node child : node.content()) {
            if (child.getNodeType() == org.dom4j.Node.ELEMENT_NODE) {
                org.dom4j.Element childElement = (org.dom4j.Element) child;
                Element newChild = parent.getOwnerDocument().createElementNS(childElement.getNamespaceURI(), childElement.getQualifiedName());
                copyAttributes(childElement, newChild);
                copyNode(childElement, newChild);
                parent.appendChild(newChild);
            } else if (child.getNodeType() == org.dom4j.Node.TEXT_NODE) {
                parent.appendChild(parent.getOwnerDocument().createTextNode(child.getText()));
            }
        }
    }

    private void copyAttributes(org.dom4j.Element source, Element target) {
        for (org.dom4j.Attribute attr : source.attributes()) {
            target.setAttributeNS(attr.getNamespaceURI(), attr.getQualifiedName(), attr.getValue());
        }
    }
}