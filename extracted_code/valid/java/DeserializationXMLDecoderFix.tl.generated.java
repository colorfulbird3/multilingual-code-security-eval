package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Service for loading application configurations.
 * This service provides methods to interpret and load configuration data.
 */
public class ConfigurationLoaderService {

    /**
     * Loads an object configuration from an XML string.
     * The method deserializes the XML content into a Java object.
     *
     * @param xmlData A string containing the XML representation of the configuration object.
     * @return The deserialized configuration object.
     */
    public Object loadConfiguration(String xmlData) {
        // Create a decoder to read the object from the XML stream.
        XMLDecoder decoder = new XMLDecoder(
            new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))
        );
        try {
            // Read and return the deserialized object.
            Object result = decoder.readObject();
            return result;
        } finally {
            decoder.close();
        }
    }
}