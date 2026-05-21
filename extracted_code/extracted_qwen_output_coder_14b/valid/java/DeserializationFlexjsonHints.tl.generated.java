package com.example.service;

import flexjson.JSONDeserializer;

/**
 * Service for loading dynamic configuration from JSON strings.
 */
public class ConfigService {

    /**
     * Loads configuration from a JSON string.
     *
     * @param jsonConfig the JSON string representing the configuration
     * @return the configuration object
     * @throws IllegalArgumentException if the input is null or empty
     * @throws RuntimeException if deserialization fails
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.isEmpty()) {
            throw new IllegalArgumentException("JSON configuration must not be null or empty");
        }
        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration from JSON: " + e.getMessage(), e);
        }
    }
}