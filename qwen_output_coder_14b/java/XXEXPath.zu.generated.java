Here's a Java implementation of the `ReportService` class with the `extractMetric` method that uses JAXP to parse XML and extract data using XPath:

```java
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
```

### Explanation:
1. **DocumentBuilderFactory and DocumentBuilder**: These are used to parse the XML string into a `Document` object which represents the entire XML document.
2. **XPath**: This is used to evaluate the XPath expression on the parsed XML document. The `XPathFactory` is used to create an `XPath` instance.
3. **XPath Expression Evaluation**: The `xPath.compile(xpathExpression).evaluate(doc, XPathConstants.STRING)` method evaluates the XPath expression and returns the result as a string.
4. **Error Handling**: The code includes basic error handling to print the stack trace if an exception occurs during parsing or evaluation.

This implementation should work for extracting metrics from XML documents using XPath expressions, as described in your requirements.