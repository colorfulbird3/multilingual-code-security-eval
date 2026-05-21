package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Create a DocumentBuilderFactory and a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML content into a Document
            Document document = builder.parse(new InputSource(new StringReader(xmlContent)));

            // Create an XPathFactory and an XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Evaluate the XPath expression and return the result as a string
            Object result = xpath.evaluate(xpathExpression, document, XPathConstants.STRING);
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error extracting metric from XML", e);
        }
    }
}