

## Opmerkingen voor implementatie

1. Alleen de naam van de service-klass moet naam van de service (niet de klas die die service implementeert).
2. Als de XML-uitdrukking komt uit een string, moet een nieuwe string uit de string gemaakt worden.
3. Als de XML-uitdrukking komt uit een string, moet de `javax.xml.xpath.XPath`-uitdrukkingstring gemaakt worden.
4. Als de XML-uitdrukking komt uit een string, moet de `javax.xml.xpath.XPathFactory`-uitdrukkingstring gemaakt worden.

## Voorbeeld

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Implementatie

```java
public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        return xpath.compile(xpathExpression).evaluate(xmlContent);
    }
}
```
