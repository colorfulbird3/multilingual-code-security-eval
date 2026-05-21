package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Parse the XML content into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new java.io.StringReader(xmlContent));
            Document document = builder.parse(inputSource);

            // Create an XPath object and compile the XPath expression
            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xpath.evaluate(xpathExpression, document, XPathConstants.NODE);

            // Return the text content of the node if found, otherwise return null
            if (node != null) {
                return node.getTextContent();
            } else {
                return null;
            }
        } catch (Exception e) {
            // Handle exceptions appropriately, for example, log the error and throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}