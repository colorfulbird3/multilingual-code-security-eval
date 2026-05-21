package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Create a new XPathFactory instance
            XPathFactory xPathFactory = XPathFactory.newInstance();
            
            // Create a new XPath instance
            XPath xPath = xPathFactory.newXPath();
            
            // Compile the XPath expression
            XPathExpression xPathExpressionCompiled = xPath.compile(xpathExpression);
            
            // Parse the XML content
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new java.io.StringReader(xmlContent));
            Document doc = dBuilder.parse(inputSource);
            
            // Evaluate the XPath expression
            Node node = (Node) xPathExpressionCompiled.evaluate(doc, XPathConstants.NODE);
            
            // Return the text content of the node if it exists
            return node != null ? node.getTextContent() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}