package com.example.service;

import flexjson.JSONDeserializer;

public class ConfigService {
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.isEmpty()) {
            return null;
        }
        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            System.err.println("Error deserializing JSON config: " + e.getMessage());
            return null;
        }
    }
}