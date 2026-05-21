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
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Configuration service class
 * Used to load XML-formatted configuration files
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
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("Configuration file does not exist or is not a file: " + configPath);
        }

        try {
            // Create SAXParserFactory instance
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true); // Enable namespace awareness
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            // Use Transformer to convert SAX event stream into a DOM tree
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            SAXSource source = new SAXSource(reader, new InputSource(new FileInputStream(configFile)));
            DOMResult result = new DOMResult();

            transformer.transform(source, result);

            return (Document) result.getNode();
        } catch (Exception e) {
            throw new Exception("XML parsing failed: " + e.getMessage(), e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```