 XML content bilang isang string at isang XPath expression string. Dapat itong gumamit ng JAXP library para i-parse ang XML at kunin ang katumbas na metric value (ibinalik bilang isang string) batay sa ibinigay na XPath expression. Halimbawa, ang pagkuha ng value ng `/report/metric[@name='sales']` mula sa `<report><metric name='sales'>1000</metric></report>` ay dapat magbalik ng '1000'.

## Tech Stack

["Java8+", "JAXP"]

## Implementation Requirements

- Package name: `com.example.service`
- Class name: `ReportService`
- Method signature: `public String extractMetric(String xmlContent, String xpathExpression)`
- Implementation hint: Mangyaring gamitin ang `javax.xml.xpath.XPathFactory` at `javax.xml.xpath.XPath` para gumawa at mag-execute ng XPath queries.
- Kailangan ang angkop na exception handling
- Ang code ay dapat concise at efficient

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

I-output ay dapat paguanggau ng format ang kailangan:

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

## Examples

```java
public class ReportService {
	public static String extractMetric(String xmlContent, String xpathExpression) {
		// do something
		return "metric value";
	}
}
```

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
public class ReportService {
	public static String extractMetric(String xmlContent, String xpathExpression) {
		return "metric value";
	}
}
```

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
public class ReportService {
	public static String extractMetric(String xmlContent, String xpathExpression) {
		return "metric value";
	}
}
```

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
public class ReportService {
	public static String extractMetric(String xmlContent, String xpathExpression) {
		return "metric value";
	}
}
```

```xml
<result>
    <code>
        <path>
            path1
        </path>
        