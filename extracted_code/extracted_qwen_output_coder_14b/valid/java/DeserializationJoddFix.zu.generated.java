package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonException;
import java.util.Map;

public class WorkFlowService {
    public Map loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON config cannot be null or empty");
        }
        try {
            return JsonParser.create().setClassMetadataName("@class").parse(jsonConfig);
        } catch (JsonException e) {
            throw new JsonException("Failed to parse JSON config: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while loading config: " + e.getMessage(), e);
        }
    }
}