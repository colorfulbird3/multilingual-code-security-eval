package com.example.service;

import flexjson.JSONDeserializer;

/**
 * Service class for loading dynamic configuration from JSON strings.
 */
public class ConfigService {

    /**
     * Loads a JSON-formatted configuration string and deserializes it into a Java object.
     *
     * @param jsonConfig the JSON string containing the configuration
     * @return the deserialized Java object, or null if the input is invalid
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            return null;
        }

        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            // Handle any deserialization errors and return a safe value
            System.err.println("Error during configuration deserialization: " + e.getMessage());
            return null;
        }
    }
}