To extract a specific metric from an XML document using Java and JAXP, you can follow the steps below. This example demonstrates how to create a service that extracts a metric value based on an XPath expression.

### Step 1: Create the ReportService Class

First, create a Java class named `ReportService` in the package `com.example.service`.

```java
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
```

### Step 2: Use the ReportService Class

You can now use the `ReportService` class to extract a metric value from an XML string.

```java
public class Main {
    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        String xmlContent = "<report><metric name='sales'>1000</metric></report>";
        String xpathExpression = "/report/metric[@name='sales']";
        String salesValue = reportService.extractMetric(xmlContent, xpathExpression);
        System.out.println("Sales Value: " + salesValue);
    }
}
```

### Explanation

1. **XPathFactory and XPath**: These classes are used to create an XPath instance which can evaluate XPath expressions.
2. **DocumentBuilder**: This class is used to parse the XML content into a DOM object.
3. **XPath Constants**: The `XPathConstants.NODESET` constant is used to indicate that the evaluation should