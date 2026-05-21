Hier is die implementering van die `XmlProcessingService`-klas met die `loadSchema`-metode:

```xml
<result>
    <code>
        <path>
            src/main/java/com/app/service/XmlProcessingService.java
        </path>
        <content>
            <![CDATA[
package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema schema;

    public void loadSchema(String schemaContent) throws Exception {
        try {
            // Create a SchemaFactory instance for the W3C XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Create a Source object from the schema content
            Source schemaSource = new StreamSource(new StringReader(schemaContent));

            // Compile the schema
            this.schema = factory.newSchema(schemaSource);
        } catch (Exception e) {
            throw new Exception("Failed to load schema", e);
        }
    }

    public Schema getSchema() {
        return schema;
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Beskrywing

1. **Pakketnaam en Klasnaam**: Die klas is geplaas in die `com.app.service`-pakket en het die naam `XmlProcessingService`.

2. **Metode Handtekening**: Die `loadSchema`-metode neem 'n string `schemaContent` as parameter en draai 'n `Exception` indien er 'n fout voorkom.

3. **Schema Laai**:
   - 'n `SchemaFactory`-instansie word geskep vir W3C XML Schema.
   - 'n `StreamSource` word geskep met die XML-skema-inhoud.
   - Die skema word kompilêr en gestoor in die `schema`-veld van die klas.

4. **Uitsonderingshantering**: Indien daar 'n fout is tydens die laai van die skema, word 'n `Exception` geraais met 'n gepaste boodskap.

5. **Getter Metode**: 'n Getter-metode `getSchema` is toegevoeg om die geladen skema-objek terug te gee.

Hier is die volledige kôde vir die `XmlProcessingService`-klas:

```java
package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema schema;

    public void loadSchema(String schemaContent) throws Exception {
        try {
            // Create a SchemaFactory instance for the W3C XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Create a Source object from the schema content
            Source schemaSource = new StreamSource(new StringReader(schemaContent));

            // Compile the schema
            this.schema = factory.newSchema(schemaSource);
        } catch (Exception e) {
            throw new Exception("Failed to load schema", e);
        }
    }

    public Schema getSchema() {
        return schema;
    }
}
```

Dit bied 'n struktureerde manier om XML-skemas dinamies te laai en om later te gebruik vir XML-validering.