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
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid or empty input path");
        }

        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        return saxParser.parse(configFile);
    }
}
            ]]>
        </content>
    </code>
</result>
```