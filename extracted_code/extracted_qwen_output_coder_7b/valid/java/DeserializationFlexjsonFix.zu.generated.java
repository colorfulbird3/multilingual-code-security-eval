package com.example.service;

import flexjson.JSONDeserializer;
import flexjson.JSONException;

public class ConfigService {

    /**
     * Implements dynamic configuration loading functionality.
     * Accepts a JSON-formatted string and deserializes it into a Java configuration object using the Flexjson library.
     *
     * @param jsonConfig JSON-formatted configuration string
     * @return The deserialized Java object
     * @throws IllegalArgumentException if jsonConfig is null, empty, or has invalid JSON format
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration string cannot be null or empty.");
        }

        try {
            return new JSONDeserializer<>().deserialize(jsonConfig);
        } catch (JSONException e) {
            // Catch exceptions possibly thrown by Flexjson during deserialization, indicating invalid JSON format
            throw new IllegalArgumentException("Invalid JSON configuration string format: " + e.getMessage(), e);
        } catch (Exception e) {
            // Catch other unexpected exceptions
            throw new RuntimeException("An unknown error occurred while loading configuration: " + e.getMessage(), e);
        }
    }
}