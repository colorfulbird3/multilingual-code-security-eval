package com.example.service;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Create an XPathFactory instance
            XPathFactory factory = XPathFactory.newInstance();
            // Create an XPath instance
            XPath xpath = factory.newXPath();

            // Parse the XML content into a DOM object
            javax.xml.parsers.DocumentBuilder builder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

            // Evaluate the XPath expression
            Object result = xpath.evaluate(xpathExpression, doc, XPathConstants.NODESET);

            if (result instanceof NodeList) {
                NodeList nodeList = (NodeList) result;
                if (nodeList.getLength() > 0) {
                    Node node = nodeList.item(0);
                    return node.getTextContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}