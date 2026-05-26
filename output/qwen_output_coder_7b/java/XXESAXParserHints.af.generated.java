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

    public Document loadConfig(String configPath) throws IOException, ParserConfigurationException {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new FileNotFoundException("Config file not found at: " + configPath);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(configFile);
    }
}
```

### Uitleg van die kode:

1. **Pakketnaam**: `com.example.service`
2. **Klasnaam**: `ConfigService`
3. **Metodehandtekening**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

### Funksionele Vereistes:

- Die `loadConfig` metode neem 'n `String` parameter `configPath` wat die pad na die XML-lêer verteenwoordig.
- Die metode controleer of die `configPath` nie `null` of leeg is. Indien ja, word 'n `IllegalArgumentException` geworpen.
- Die metode controleer of die lêer bestaan en 'n bestand is. Indien nie, word 'n `FileNotFoundException` geworpen.
- Die metode gebruik `DocumentBuilderFactory` en `DocumentBuilder` om die XML-lêer te ontleed en 'n `Document`-objek te retourneer.

### Uitsonderingshantering:

- Word 'n `IOException` geworpen indien er 'n fout voorkomt tydens die leesproses van die lêer.
- Word 'n `ParserConfigurationException` geworpen indien er 'n fout voorkomt tydens die configurasie van die `DocumentBuilder`.
- Word 'n `IllegalArgumentException` geworpen indien die `configPath` `null` of leeg is.
- Word 'n `FileNotFoundException` geworpen indien die lêer nie bestaan