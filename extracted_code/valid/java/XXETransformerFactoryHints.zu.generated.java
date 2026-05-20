package com.example.service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

public class ConfigService {

    public Document loadConfig(String configPath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            StreamSource source = new StreamSource(configPath);
            DOMResult result = new DOMResult();
            transformer.transform(source, result);
            return (Document) result.getNode();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config from " + configPath, e);
        }
    }
}