1
        ]]>
        </content>
    </code>
</result>
```

Maak hierdie bestand aan en voer het in Java-proces.

## Verwysel

- [Java DocumentBuilderFactory](https://docs.oracle.com/javase/tutorial/jaxp/parsers/create-dbf.html)
- [DOM4J](http://dom4j.sourceforge.net/)
- [Exception Handling in Java](https://www.javatpoint.com/java-exception-handling)

---

### Uitvoerbeeld

Als die gebruiker een XML-stringlêer invoert met de volgende inhoud:

```xml
<configuration>
    <server>example.com</server>
    <port>8080</port>
    <database>db123</database>
</configuration>
```

Die uitvoer zou er als volgt zijn:

```xml
<result>
    <code>
        <path>
            /path/to/config.xml
        </path>
        <content>
            <![CDATA[
            <configuration>
                <server>example.com</server>
                <port>8080</port>
                <database>db123</database>
            </configuration>
            ]]>
        </content>
    </code>
</result>
```

## Implementering

Voor implementering gebruik die volgende code:

```java
package com.example.service;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Configuration service class
 * Used to load XML-formatted configuration files
 */
public class ConfigService {

    /**
     * Loads an XML configuration based on the user-specified configuration file path
     *
     * @param configPath Path to the configuration file
     * @return Parsed XML Document object
     * @throws Exception Thrown when the file does not exist or parsing fails
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration file path cannot be empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("Configuration file does not exist: " + configPath);
        }

        if (!configFile.isFile()) {
            throw new IOException("Specified path is not a file: " + configPath);
        }

        try {
            SAXReader reader = new SAXReader();
            return reader.read(configFile);

        } catch (SAXException e) {
            throw new Exception("XML file format error: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new Exception("Failed to read configuration file: " + e.getMessage(), e);
        }
    }
}
```

Met die implementering kan die gebruiker-eindtoestand worden gecontroleerd met die volgende code:

```java
package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigServiceTest {

    @Autowired
    private ConfigService configService;

    @Test
    void testLoadConfig() throws Exception {
        String configPath = "/path/to/config.xml";
        Document config = configService.loadConfig(configPath);

        Element rootElement = config.getRootElement();
        System.out.println(rootElement.getName());
        System.out.println(rootElement.attributeValue("server"));
        System.out.println(rootElement.attributeValue("port"));
        System.out.println(rootElement.attributeValue("database"));
    }
}
```

Dit geeft als uitvoer:

```
configuration
example.com
8080
db123
```

Daarom kan die configuratiefile correct gelees word en aangehaal word.