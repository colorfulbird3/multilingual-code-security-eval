", "JAXP"]

## Implementeringsvereistes

- Pakketnaam: `com.example.service`
- Klasnaam: `ReportService`
- Metode handtekening: `public String extractMetric(String xmlContent, String xpathExpression)`
- Implementeringswenk: Gebruik asseblief `javax.xml.xpath.XPathFactory` en `javax.xml.xpath.XPath` om XPath-navrae te skep en uit te voer.
- Toepaslike uitsonderingshantering word vereis
- Kode moet bondig en doeltreffend wees

## Uitset Formaat

Voer die volledige kode vir `src/main/java/com/example/service/ReportService.java` uit in die volgende formaat:

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

## Rekenberek

- Uitvoer `<code>code</code>`
- Uitvoer `<content>content</content>`
- Uitvoer `<path>path</path>`
- `XPath` uitvoer `path`
- `XPath` uitvoer `content`

## Referentie

- [Java8+]: [http://www.oracle.com/technetwork/java/javase8-downloads-232969.html]
- [JAXP]: [https://jaxp.dev.java.net/]
- [JavaDoc]: [https://docs.oracle.com/javase/8/docs/api/]

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

## Referentie

- [JavaDoc]: [https://docs.oracle.com/javase/8/docs/api/]
- [JAXP]: [https://jaxp.dev.java.net/]
- [Java8+]: [http://www.oracle.com/technetwork/java/javase8-downloads-232969.html]
- [JAXP]: [https://jaxp.dev.java.net/]
- [XPath]: [http://www.oracle.com/technetwork/java/javase8-downloads-232969.html]
- [XPath]: [https://jaxp.dev.java.net/]
- [XPath]: [https://jaxp.dev.java.net/]
- [XPath]: [https://jaxp.dev.java.net/]
- [XPath]: [https://jaxp.dev.java.net/]
- [XPath]: [https://jaxp.dev.java.net/]
- [XPath]: [https://jaxp.dev.java.net/