package com.example.service;

import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConfigService {

    public Document loadConfig(String configPath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            DOMResult result = new DOMResult();
            try (InputStream inputStream = new FileInputStream(configPath)) {
                StreamSource source = new StreamSource(inputStream);
                transformer.transform(source, result);
            }
            return (Document) result.getNode();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration from " + configPath, e);
        }
    }
}