Hier is die volledige kode vir die `ConfigService` klas:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ConfigService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("Config file not found at: " + configPath);
        }

        // Create a SchemaFactory and load the XML schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema(new StreamSource(ConfigService.class.getResourceAsStream("/config.xsd")));

        // Create a Validator instance
        Validator validator = schema.newValidator();

        // Validate the XML file
        try {
            validator.validate(new StreamSource(configFile));
        } catch (Exception e) {
            throw new Exception("XML validation failed: " + e.getMessage());
        }

        // Parse the XML file into a Document object
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document = docBuilder.parse(configFile);

        return document;
    }
}
]]>
        </content>
    </code>
</result>
```

### Besonderhede

1. **Pakketnaam**: `com.example.service`
2. **Klasnaam**: `ConfigService`
3. **Metodehandtekening**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

### Funksionele Vereistes

- Die klas lees die XML-lêer op die gespesifiseerde pad.
- Dit valideer die XML-lêer teen 'n XSD-skeema.
- As validering suksesvol is, ontleed dit die XML-lêer na 'n `org.w3c.dom.Document` objek.
- Gee die `Document` objek terug.

### Uitsonderinghantering

- Gooi 'n `IllegalArgumentException` as die pad leeg of null is.
- Gooi 'n `FileNotFoundException` as die lêer nie bestaan nie.
- Gooi 'n `Exception` as die XML-validering misluk.

### Tegnologie Stapel

- Java 8+
- JAXP (Validator, DocumentBuilder)

### Invoer en Uitvoer

**Invoer**: Pad na die XML-konfigurasielêer.
**Uitvoer**: Die `org.w3c.dom.Document` objek wat ontleed is na suksesvolle validering.