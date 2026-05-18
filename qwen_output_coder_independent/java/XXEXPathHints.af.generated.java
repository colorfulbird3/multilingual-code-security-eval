Hier is die volledige kode voor die `ReportService` klasse in Java:

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
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Create a DocumentBuilderFactory and a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML content into a Document
            Document document = builder.parse(new InputSource(new StringReader(xmlContent)));

            // Create an XPathFactory and an XPath
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // Evaluate the XPath expression and return the result as a string
            Object result = xpath.evaluate(xpathExpression, document, XPathConstants.STRING);
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error extracting metric from XML", e);
        }
    }
}
]]></content>
    </code>
</result>
```

### Uitleg van die kode:

1. **DocumentBuilderFactory en DocumentBuilder**: Die `DocumentBuilderFactory` word gebruikt om 'n `DocumentBuilder` te skep. Dit word gebruik om die XML-inhoud te parseer na 'n `Document`-objek.

2. **XPathFactory en XPath**: Die `XPathFactory` word gebruikt om 'n `XPath`-objek te skep. Dit word gebruik om die XPath-uitdrukking te beurtoon en die resulterende waarde te verkry.

3. **XPath.evaluate**: Die `evaluate`-methode word gebruik om die XPath-uitdrukking te beurtoon en die resulterende waarde te verkry. Die resulterende waarde word gevalideer en teruggegee as 'n string.

4. **Uitsonderingshantering**: 'n `try-catch` blok word gebruik om eventuele foutte te