Hier is die Java-kode vir die `XmlProcessingService` klas wat die `loadSchema`-metode implementeert:

```java
package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema loadedSchema;

    public void loadSchema(String schemaContent) throws Exception {
        // Create a SchemaFactory for XML Schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Create a StreamSource from the schema content
        StreamSource schemaSource = new StreamSource(new StringReader(schemaContent));

        // Compile the schema
        loadedSchema = schemaFactory.newSchema(schemaSource);
    }

    // Method to get the loaded schema (for validation purposes)
    public Schema getLoadedSchema() {
        return loadedSchema;
    }
}
```

### Uitleg van die kode:

1. **Package en Importeeringsinjektie**:
   - Die klas word in die `com.app.service` pakket geplaas.
   - Die benodigde JAXP-klassen word ingevoer om die XML-skeemas te laai en te compileer.

2. **Klasse en Vieringsklaas**:
   - Die `XmlProcessingService` klas word gedefinieer met 'n privaat attribuut `loadedSchema` om die laai 'n Skema-objek te hou.

3. **loadSchema-metode**:
   - Die `loadSchema`-metode neem 'n `String` parameter `schemaContent` wat die XML-skeema-inhoud bevat.
   - 'n `SchemaFactory` word gecreeër met die `XMLConstants.W3C_XML_SCHEMA_NS_URI` om 'n XML-skeema te ondersteun.
   - 'n `StreamSource` word gecreeër met 'n `StringReader` om die schema-inhoud te lees.
   - Die `newSchema`-metode van `SchemaFactory` word gebruik om die schema te compileer en 'n `Schema`-objek te saamstel.
   - Die saamgestelde `Schema`-objek word opgeslag in die `loadedSchema` attribuut.

4. **getLoadedSchema