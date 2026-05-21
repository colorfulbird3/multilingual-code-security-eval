Hier is die implementering van die `extractMetric`-metode in die `ReportService`-klas, volgens die aangebiede vereistes:

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
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Parse the XML content into a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

            // Create an XPath object
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Evaluate the XPath expression
            NodeList nodeList = (NodeList) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NODESET);

            // Check if the node list is not empty and return the text content of the first node
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            } else {
                throw new IllegalArgumentException("No matching nodes found for the XPath expression: " + xpathExpression);
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

### Besonderhede van die Implementering:

1. **XML Onderstryking**: Die XML-inhoud word gebruik van `DocumentBuilder` en `DocumentBuilderFactory` om in 'n DOM-document te onderstryk.

2. **XPath Onderstryking**: Die `XPathFactory` en `XPath` klasses word gebruik om die XPath-uitdrukking te compileer en uit te voer.

3. **Uitsonderingshantering**: Die metode hanteer verskeie soorte uitsonderings, insluitend `XPathExpressionException` en ander DOM-onderstrykingsuitsonderings. Dit gee 'n algemene `RuntimeException` terug met 'n toelichtende boodskap.

4. **Kode Bondigheid**: Die kode is bondig en fokus op die vereiste funksionaliteit van die metode.

Hierdie implementering moet jou in staat stellen om metriek dinamies uit XML-verslae te onttrek met behulp van XPath-uitdrukkinge.