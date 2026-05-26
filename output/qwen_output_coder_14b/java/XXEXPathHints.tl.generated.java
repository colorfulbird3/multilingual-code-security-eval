```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ReportService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(xpathExpression);

            Node resultNode = (Node) expr.evaluate(document, XPathConstants.NODE);
            if (resultNode != null) {
                return resultNode.getTextContent();
            } else {
                throw new IllegalArgumentException("No node found for the given XPath expression.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting metric from XML", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```