```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ConfigService.java</path>
        <content><![CDATA[
package com.example.service;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and return the Document object
            return builder.parse(configFile);

        } catch (ParserConfigurationException e) {
            throw new Exception("XML parser configuration error: " + e.getMessage(), e);
        } catch (SAXException e) {
            throw new Exception("XML file format error: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new Exception("Failed to read configuration file: " + e.getMessage(), e);
        }
    }
}
]]></content>
    </code>
</result>
```