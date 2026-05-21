Hier is die implementering van die `ReportService` klas met die `extractMetric` metode:

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
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // Parse the XML content into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new java.io.StringReader(xmlContent));
            Document document = builder.parse(inputSource);

            // Create an XPath object and compile the XPath expression
            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xpath.evaluate(xpathExpression, document, XPathConstants.NODE);

            // Return the text content of the node if found, otherwise return null
            if (node != null) {
                return node.getTextContent();
            } else {
                return null;
            }
        } catch (Exception e) {
            // Handle exceptions appropriately, for example, log the error and throw a custom exception
            e.printStackTrace();
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```

Hier is 'n kort beskrywing van die implementering:

1. **Pakketnaam en Klasnaam**: Die klas word geïmplementeer in die `com.example.service` pakket met die naam `ReportService`.

2. **Metode Handtekening**: Die `extractMetric` metode neem twee parameters:
   - `xmlContent`: 'n String wat die XML-inhoud bevat.
   - `xpathExpression`: 'n String wat die XPath-uitdrukking bevat om die gewenste metriek te onttrek.

3. **XML Parsing**: Die XML-inhoud word gebruik van `DocumentBuilderFactory` en `DocumentBuilder` geparseer om 'n `Document` objek te skep.

4. **XPath Ontleding**: Die `XPath` objek word geskep en die XPath-uitdrukking word gecompileer. Die `evaluate` metode word gebruik om die ooreenstemmende knooppunt uit die XML te verkry.

5. **Uitsonderingshantering**: Alle exceptions word afgehandel met 'n `try-catch` blok. Hier kan u beslise om 'n aangepaste exception te werp of om die fout te log.

6. **Returwaarde**: Indien 'n knooppunt gevind word, word die teksinhoud van die knooppunt teruggegee. Indien nie, word `null` teruggegee.

Hier is 'n voorbeeld van hoe u die `extractMetric` metode kan gebruik:

```java
public class Main {
    public static void main(String[] args) {
        String xmlContent = "<report><metric name='sales'>1000</metric></report>";
        String xpathExpression = "/report/metric[@name='sales']";

        ReportService reportService = new ReportService();
        String metricValue = reportService.extractMetric(xmlContent, xpathExpression);

        System.out.println("Extracted Metric Value: " + metricValue);
    }
}
```

Hier word die `extractMetric` metode aangeroep met 'n voorbeeld XML-string en 'n XPath-uitdrukking om die waarde van die "sales" metriek te onttrek. Die afgedrukte waarde zou "1000" wees.