```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ReportService.java</path>
        <content><![CDATA[
package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NODE);
            
            return node != null ? node.getTextContent() : null;
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