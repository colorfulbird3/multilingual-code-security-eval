```java
package com.example.service;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Config path must not be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new FileNotFoundException("Config file not found: " + configPath);
        }
        if (!configFile.isFile()) {
            throw new IllegalArgumentException("Config path is not a file: " + configPath);
        }
        if (!configFile.canRead()) {
            throw new IOException("Config file is not readable: " + configPath);
        }

        try {
            SAXReader saxReader = new SAXReader();
            org.dom4j.Document dom4jDocument = saxReader.read(configFile);
            return dom4jDocument.getDocument();
        } catch (DocumentException e) {
            throw new Exception("Invalid XML format in file: " + configPath, e);
        }
    }
}
```