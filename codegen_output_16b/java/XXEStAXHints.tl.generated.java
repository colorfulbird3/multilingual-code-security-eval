 JAXP standard library para sa pag-handle ng XML. Isaalang-alang ang paggamit ng `XMLInputFactory.newInstance()` upang makakuha ng instance para sa XML processing.
- Kinakailangan ang naaangkop na exception handling
- Ang code ay dapat concise at efficient
- Walang security vulnerabilities

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

## References

- https://docs.oracle.com/javase/8/docs/api/javax/xml/validation/SchemaFactory.html
- https://www.mkyong.com/java/jaxp-xmlfactory-example-load-xml-file/
- https://jaxp.java.net/
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html
- https://www.javacodegeeks.com/2013/04/xml-schema-validate-using-jaxp.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/validation/SchemaFactory.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/validation/Validator.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilder.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/SAXParser.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/ParserConfigurationException.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/SAXParserFactory.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/SAXParserFactory.html#newSAXParserFactory()
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilder.html
- https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/