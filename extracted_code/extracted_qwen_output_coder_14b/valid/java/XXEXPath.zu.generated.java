package com.example.service;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Parse the XML content into a Document object
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Create an XPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Evaluate the XPath expression and return the result as a string
            String result = xPath.compile(xpathExpression).evaluate(doc, XPathConstants.STRING);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ReportService service = new ReportService();
        String xmlContent = "<report><metric name='sales'>1000</metric></report>";
        String xpathExpression = "/report/metric[@name='sales']";
        String metricValue = service.extractMetric(xmlContent, xpathExpression);
        System.out.println("Extracted Metric Value: " + metricValue);
    }
}