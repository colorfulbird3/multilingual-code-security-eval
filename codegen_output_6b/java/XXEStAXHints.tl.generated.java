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

## Examples

## External Dependencies

- JAXP 1.1.3

## External References

- [XML Schema validation](http://www.w3.org/TR/xmlschema-validation/)

## External documentation

- http://www.ibm.com/developerworks/library/x-jaxp/index.html

## References

- [Java XML Schema Validation](http://www.ibm.com/developerworks/library/x-jaxp/index.html)
*/

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class SchemaValidationService {
  private static final String W3_SCHEMA_XSD_FILENAME = "w3_schema.xsd";
  private static final String W3_SCHEMA_XML_FILENAME = "w3_schema.xml";
  private static final String CONTENT_TYPE_XML = "application/xml";

  public boolean validateSchema(String schemaContent) {
    StringReader reader = new StringReader(schemaContent);
    StreamSource sourceXML = new StreamSource(reader);

    try {
      SAXParserFactory spf = SAXParserFactory.newInstance();
      spf.setNamespaceAware(true);
      SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      Schema schema = sf.newSchema(new StreamSource(this.getClass().getResourceAsStream(W3_SCHEMA_XSD_FILENAME)));
      Validator validator = schema.newValidator();