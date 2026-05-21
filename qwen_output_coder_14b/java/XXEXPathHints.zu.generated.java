Here's a Java implementation of the `ReportService` class with the `extractMetric` method using JAXP and XPath to extract metrics from XML content:

```java
package com.example.service;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Parse the XML content into a Document object
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));
            doc.getDocumentElement().normalize();

            // Create an XPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Evaluate the XPath expression
            Node node = (Node) xPath.compile(xpathExpression).evaluate(doc, XPathConstants.NODE);

            // Return the text content of the node if found, otherwise return null
            if (node != null) {
                return node.getTextContent();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

This implementation uses JAXP to parse the XML content and XPath to evaluate the given XPath expression. The method returns the text content of the node if it is found, or null if it is not found. This approach allows for flexible extraction of specific metrics from XML data based on the provided XPath expression.