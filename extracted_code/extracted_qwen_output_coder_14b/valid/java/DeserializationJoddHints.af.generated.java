package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonException;

import java.util.Map;

public class WorkFlowService {

    public Map loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            Map configMap = parser.parse(jsonConfig);
            return configMap;
        } catch (JsonException e) {
            // Handle JSON parsing error
            System.err.println("Error parsing JSON configuration: " + e.getMessage());
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }
}