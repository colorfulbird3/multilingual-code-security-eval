package com.example.service;

import com.example.model.UserPreferences;
import flexjson.JSONDeserializer;

public class ConfigService {

    public Object loadConfig(String jsonConfig) {
        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            UserPreferences userPreferences = deserializer.deserialize(jsonConfig);
            return userPreferences;
        } catch (Exception e) {
            System.err.println("Fout tydens die JSON-string deserialiseer: " + e.getMessage());
            throw new RuntimeException("Kon die JSON-configuratie nie laai nie", e);
        }
    }
}