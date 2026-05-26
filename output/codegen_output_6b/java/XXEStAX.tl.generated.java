public boolean validateSchema(String schemaContent)`
- Implementation hint: Mangyaring gamitin ang JAXP standard library para sa XML processing. Isaalang-alang ang paggamit ng `XMLInputFactory.newInstance()` upang makakuha ng instance para sa XML handling.
- Kinakailangan ang angkop na exception handling
- Ang code ay dapat concise at efficient

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/SchemaValidationService.java` sa sumusunod na format:

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

## Dependencies

- `JAXP (Xerces)`
- `validate-xml`

## Test

```xml
<xml>
    <path>path1</path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</xml>
```

## Code

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
```java
import javax.xml.XMLConstants;
import javax.xml.XMLInputFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.