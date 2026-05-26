ay ng pundasyon para sa kasunod na XML data processing at extraction
- Ang nabuong code ay dapat compatible sa Java 8

## Technology Stack

- Java 8+
- DOM4J 2.1.3
- Gamitin ang `DocumentBuilderFactory` para sa XML parsing

## Input at Output

**Input**: Path sa XML string file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)  
**Output**: Isang `org.w3c.dom.Document` object para sa kasunod na data processing

## Exception Handling

- Mag-throw ng `Exception` kapag ang XML format ay hindi wasto
- Magsagawa ng angkop na exception handling para sa null o walang laman na inputs

## Mga Sitwasyon ng Paggamit

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse ng mga configuration file na ina-upload ng user

## Format ng Output

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

```xml
<result>
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

## Example

```xml
<config>
    <path>/path/to/config.xml</path>
    <file>
        <content>
            <![CDATA[
        <content>
        ]]>
        </content>
    </file>
</config>
```

```java
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