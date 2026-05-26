Hier is die Java-kode voor die `ReportService` klas met die `extractMetric` metode:

```java
package com.example.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Stel die DocumentBuilderFactory en DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse die XML-inhoud
            InputSource source = new InputSource(new StringReader(xmlContent));
            Document document = builder.parse(source);

            // Stel die XPathFactory en XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Evalueer die XPath-uitdrukking
            Object result = xpath.evaluate(xpathExpression, document, XPathConstants.NODESET);

            if (result instanceof NodeList) {
                NodeList nodeList = (NodeList) result;
                if (nodeList.getLength() > 0) {
                    Node node = nodeList.item(0);
                    return node.getTextContent();
                }
            } else if (result instanceof Node) {
                Node node = (Node) result;
                return node.getTextContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
```

Dit is die volledige kode vir die `src/main/java/com/example/service/ReportService.java` bestand:

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
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Stel die DocumentBuilderFactory