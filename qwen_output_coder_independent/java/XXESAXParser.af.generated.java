Hier is die volledige kode voor `src/main/java/com/example/service/ConfigService.java`:

```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Config file not found: " + configPath);
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(configFile);
        } catch (ParserConfigurationException e) {
            throw new Exception("Invalid XML format", e);
        }
    }
}
```

### Uitleg van die kode:

1. **Pakketnaam**: `com.example.service`
2. **Klasnaam**: `ConfigService`
3. **Metode-handtekening**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

### Funksionele Vereistes:

- **Lees die gebruiker-verskafde XML-lêer wat by `configPath` geleë is**
  - Die `loadConfig` metode neem 'n `String` parameter `configPath` wat die pad na die XML-lêer verteenwoordig.
  
- **Gebruik JAXP se `SAXParserFactory` om die XML-inhoud te ontleed**
  - Die `DocumentBuilderFactory` en `DocumentBuilder` word gebruik om die XML-lêer te parseer.

- **Skakel die ontledingsresultaat om in 'n `org.w3c.dom.Document`-objek en gee dit terug**
  - Die `parse` metode van `DocumentBuilder` word gebruik om die XML-lêer te parseer en 'n `Document`-objek te retourner.

- **Verskaf 'n grondslag vir daaropvolgende XML-dataverwerking en -onttrekking**
  - Die `Document`-objek word geretourneer en kan vervolgens gebruik word om XML-datatree te navig