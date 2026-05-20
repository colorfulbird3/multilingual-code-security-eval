package com.example.config.service;

import com.example.config.bean.UserPreferences;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.beans.XMLDecoder;

public class ConfigurationLoaderService {

    /**
     * Loads the configuration from an XML string and returns the corresponding Java object.
     *
     * @param xmlData The XML string containing the configuration.
     * @return The Java object representing the configuration.
     * @throws IOException If an I/O error occurs during deserialization.
     */
    public Object loadConfiguration(String xmlData) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(xmlData.getBytes())) {
            XMLDecoder decoder = new XMLDecoder(bis);
            return decoder.readObject();
        }
    }
}