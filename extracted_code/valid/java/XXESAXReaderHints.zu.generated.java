package com.example.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class ConfigService {

    public org.w3c.dom.Document loadConfig(String configPath) {
        try {
            SAXReader saxReader = new SAXReader();
            Document dom4jDocument = saxReader.read(new File(configPath));
            String xmlContent = dom4jDocument.asXML();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlContent));
            return builder.parse(is);
        } catch (DocumentException | ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            throw new RuntimeException("Failed to load and parse XML configuration", e);
        }
    }
}