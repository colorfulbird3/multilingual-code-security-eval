package com.example.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentBuilderFactory;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Configuration service class
 * Used to load XML-formatted configuration files
 */
public class ConfigService {

    /**
     * Loads an XML configuration based on the user-specified configuration file path
     *
     * @param configPath Path to the configuration file
     * @return The parsed XML document object
     * @throws Exception Thrown when the file does not exist or parsing fails
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration file path cannot be empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        try {
            SAXReader reader = new SAXReader();
            Document dom4jDoc = reader.read(configFile);

            // Convert the dom4j Document to a W3C Document
            return convertDom4jToW3cDocument(dom4jDoc);

        } catch (Exception e) {
            throw new Exception("XML parsing failed: " + e.getMessage(), e);
        }
    }

    private Document convertDom4jToW3cDocument(org.dom4j.Document dom4jDoc) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        // Create a new document with the same root element as the dom4j document
        String rootElementName