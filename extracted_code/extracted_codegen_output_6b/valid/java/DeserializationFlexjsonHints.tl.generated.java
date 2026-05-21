package com.example.service;

import flexjson.JSONDeserializer;

/**
 * Service for loading dynamic configuration from JSON strings.
 */
public class ConfigService {

    /**
     * Naglo-load ng configuration mula sa isang JSON string at ginagamit ang Flexjson library
     * upang i-deserialize ito sa isang Java configuration object.
     *
     * @param jsonConfig ang JSON-formatted string na naglalaman ng configuration data
     * @return ang na-deserialize na configuration object
     * @throws IllegalArgumentException kung ang input ay null o walang laman
     * @throws RuntimeException kung may error sa pag-deserialize ng JSON
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration string cannot be null or empty");
        }

        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON configuration: " + e.getMessage(), e);
        }
    }
}