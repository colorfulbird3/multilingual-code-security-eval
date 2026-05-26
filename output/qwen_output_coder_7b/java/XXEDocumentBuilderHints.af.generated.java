Hier is die volledige kode voor die `ConfigService` klasse in Java:

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
            throw new FileNotFoundException("Config file not found at: " + configPath);
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(configFile);
        } catch (ParserConfigurationException | IOException e) {
            throw new Exception("Failed to parse XML configuration file", e);
        }
    }
}
```

### Uitleg van die kode:

1. **Pakketnaam**: `com.example.service`
2. **Klasnaam**: `ConfigService`
3. **Metode-handtekening**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

### Funksionele Vereistes:

- **Lees die gebruiker-verskafde XML-string wat by die `configPath` geleë is**: Die `loadConfig` metode neem 'n `configPath` parameter wat die pad na die XML-lêer verteenwoordig.
- **Gebruik JAXP se `DocumentBuilderFactory` om die XML-inhoud te ontleed**: Die `DocumentBuilderFactory` en `DocumentBuilder` word gebruik om die XML-lêer te parseer.
- **Skakel die ontlede resultaat om in 'n `org.w3c.dom.Document`-objek en gee dit terug**: Die parseerde XML-word omgezet in 'n `Document`-objek wat teruggegee word.
- **Hanteer verskillende XML-formate, insluitend eenvoudige konfigurasielêers en komplekse datastrukture**: Die `DocumentBuilder` word in staat gestaan om verskillende XML-formate te parseer.
- **Verskaf 'n grondslag vir daaropvolgende XML-dataverwerking en -