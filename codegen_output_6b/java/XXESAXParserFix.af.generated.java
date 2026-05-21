

## Uitvoer

```
Resultaat van `loadConfig`: `<result>
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

## Gebruikskode

```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import javax.xml.transform.TransformerFactory;
import org.xml.sax.SAXException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Configuration service class
 * Used to load XML configuration from the specified file path provided by the user
 *
 * @author Jeroen
 * @version 2017-12-10
 */
public class ConfigService {

    /**
     * Loads XML configuration from the specified file path provided by the user
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
        if (!configFile.exists() ||!configFile.isFile()) {
            throw new IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        try {
            // Create SAXParserFactory instance
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            // Use Transformer to convert SAX event stream