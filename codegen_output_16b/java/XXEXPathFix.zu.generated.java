

## Sebenzisa Umsebenzi Wokukhipha

Umsebenzi wokukhipha elandelayo:

```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## I-`extractMetric` Umuqalelo

Umuqalelo lwangaphakathi lwenkampani lokukhiqiza imibiko lusebenzisa efomethini ye-`src/main/java/com/example/service/ReportService.java` ukuhlaziywa kwemibiko okuzenzakalelayo:

```java
package com.example.service;

public class ReportService {

    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // 1. Initialize XML processing factories
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Parse the XML content into a DOM Document
            InputSource is = new InputSource(new StringReader(xmlContent));
            Document doc = builder.parse(is);

            // 3. Create an XPath object to evaluate expressions
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // 4. Compile and evaluate the XPath expression
            XPathExpression expr = xpath.compile(xpathExpression);
            return (String) expr.evaluate(doc, XPathConstants.STRING);

        } catch (ParserConfigurationException | SAXException | IOException | javax.xml.xpath.XPathExpressionException e) {
            // In case of any processing error, return null.
            System.err.println("An error occurred during XML processing: " + e.getMessage());
            return null;
        }
    }
}
```

## I-`extractMetric` Uqhalelelo