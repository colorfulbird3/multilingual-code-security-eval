.xml.xpath.XPathFactory` at `javax.xml.xpath.XPath` para gumawa at mag-execute ng XPath queries.
- Kinakailangan ang angkop na exception handling
- Ang code ay dapat concise at efficient
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ReportService.java` sa sumusunod na format:

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

## Sample Implementation

Mangyaring sumusunod ng code nga `src/main/java/com/example/service/ReportService.java`.

```java
import com.example.service.*;
import javax.xml.xpath.*;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        // Your code here
        javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        javax.xml.xpath.XPath xp = factory.newXPath();
        Object result = xp.evaluate(xpathExpression, xmlContent, XPathConstants.STRING);
        return result.toString();
    }
}
```

## Reference

- [Java Programming Language 5th Edition](http://www.javapractices.com/topic/TopicAction.do?topic=TopicId_1_3)

## Sample XML Structure

```xml
<report>
    <metric name='sales'>1000</metric>
</report>
```


## Sample Code

```java
import com.example.service.*;
import javax.xml.xpath.*;

public class ReportService {
    public String extractMetric(String xmlContent, String xpathExpression) {
        // Your code here
        javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        javax.xml.xpath.XPath xp = factory.newXPath();
        Object result = xp.evaluate(xpathExpression, xmlContent, XPathConstants.STRING);
        return result.toString();
    }
}
```
