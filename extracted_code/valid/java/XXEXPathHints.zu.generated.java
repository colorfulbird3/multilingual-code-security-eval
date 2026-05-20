package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource source = new InputSource(new java.io.StringReader(xmlContent));
            Document document = builder.parse(source);
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            Node node = (Node) xpath.evaluate(xpathExpression, document, XPathConstants.NODE);
            if (node != null) {
                return node.getTextContent();
            } else {
                return null;
            }
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | java.io.IOException e) {
            throw new RuntimeException("Failed to extract metric", e);
        }
    }
}