 javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(schemaContent));

            while (reader.hasNext()) {
                reader.next();
            }
            return true;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
    }
}
</code>

## Uitsetformaat

Lewer die volledige reggestelde kode vir `src/main/java/com/example/service/SchemaValidationService.java` in die volgende formaat:

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

## Uitgave

In gebruik als uitzendingvoor, uw schema-validatie functie met de gegeven XML-skema, dat in een `src/main/resources/xml/schema/` directory dus bevat.

## Uitlagen

- `jaxp-xml-validation-1.1_01.jar` (het groot werkzijd)
- `jaxp-xml-validation-schema-1.1_01.jar` (het groot werkzijd)
- `jaxp-xml-validation-unmarshaller-1.1_01.jar` (het groot werkzijd)
- `jaxp-xml-validation-xpath-1.1_01.jar` (het groot werkzijd)

## Data gevoegd

- `src/main/resources/xml/validation-schema.xml`
- `src/main/resources/xml/validation-schema-content.xml`

## Uitgave

Uw gegeven XML-skema uitgevoerd door `SchemaValidationService.validateSchema(schemaContent)` (omwel dat uitgevoerd wordt).


## Voorbeeld

```xml
<root>
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
</root>
```

## Voorbeeld:

Het XML-skema eerst uitevoeren en zoeken op de <code>schema</code> tag, en dus uit het schema-validatie functie.

## Voorbeeld:

Nu is het XML-skema uittevoeren en voor elke `<code>path</code> tag gezocht worden, en dus uit het schema-validatie functie.

## Voorbeeld:
