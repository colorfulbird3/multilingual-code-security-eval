Service.java` sa sumusunod na format:

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

Sample implementation lang:

```java
// Sample Implementation

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        //... your code here...
        //... or...
        //... or...
        //... or...
        try {
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
            javax.xml.parsers.Document doc = builder.parse(new InputSource(new StringReader(schemaContent)));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
```

## References:


- [Java 8+](https://www.java.com/en/blog/whats-new-in-java-8-0-dealing-with-datetimes-locales-and-zones)
- [JAXP](http://java.sun.com/javase/6/docs/jre/api/javax/xml/parsers/DocumentBuilderFactory.html)
- [XML Schema 1.0 Part 2](https://www.w3.org/TR/xmlschema-1/#schema-refer)
"""
