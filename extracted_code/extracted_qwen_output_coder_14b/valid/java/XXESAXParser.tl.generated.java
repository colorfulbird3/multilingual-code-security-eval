package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File configFile = new File(configPath);
        if (!configFile.exists()) {
            throw new IOException("File not found: " + configPath);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        try {
            return saxParser.parse(new InputSource(configFile));
        } catch (Exception e) {
            throw new Exception("Invalid XML format", e);
        }
    }
}