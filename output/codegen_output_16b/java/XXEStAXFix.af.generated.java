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

De `<code>` tag is automatisk gekoppeld en de `<path>` regels wordt afgevoerd op bestaande XML-skema.

De `<content>` regel wordt afgevoerd op de XML-onderteks.

### Bekomings

## Aanbieder kies voor regels

Regels worden afgebied naar XML-skema-elementen. Dit is maar een eenvoudige manier om die regels te verwerken.

### Uitdraai

## Uitdraai

Maak `SchemaValidationService.java` en `SchemaValidationServiceTest.java` aan.

## Implementatie voorlop

## Algemeen

Deze service kan gebruikt worden voor alle web aanbieders.

## Bekomings

## Aanbieder kies voor regels

Verenig 'Aanbieder' kies regels af.

## Uitdraai

## Algemeen

## Bekomings

## Onthouding

De service kan niet aan de gebruiker worden aangetroffen en is daarom niet gebruikt in `com.example.service.SchemaValidationServiceTest`.
