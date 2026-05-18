```java
package com.example.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.DocumentBuilderFactory;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: configPath cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXReader reader = new SAXReader();
        Document domDocument = reader.read(configFile);

        return convertToW3CDomDocument(domDocument);
    }

    private org.w3c.dom.Document convertToW3CDomDocument(Document dom4jDocument) throws Exception {
        DOMImplementation domImpl = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
        DocumentType doctype = domImpl.createDocumentType(
                dom4jDocument.getRootElement().getName(),
                dom4jDocument.getRootElement().getPublicId(),
                dom4jDocument.getRootElement().getSystemId()
        );

        org.w3c.dom.Document w3cDocument = domImpl.createDocument(null, dom4jDocument.getRootElement().getName(), doctype);
        Element rootElement = w3cDocument.getDocumentElement();

        convertDom4jElementToW3cElement(dom4jDocument.getRootElement(), rootElement);

        return w3cDocument;
    }

    private void convertDom4jElementToW3cElement(org.dom4j.Element dom4jElement, org.w3c.dom.Element w3cElement) {
        for (org.dom4j.Attribute attribute : dom4jElement.attributes()) {
            w3cElement.setAttribute(attribute.getName(), attribute.getValue());
        }

        for (Object child : dom4jElement.content()) {
            if (child instanceof org.dom4j.Element) {
                org.dom4j.Element dom4jChild = (org.dom4j.Element) child;
                org.w3c.dom.Element w3cChild = w3cDocument.createElement(dom4jChild.getName());
                convertDom4jElementToW3cElement(dom4