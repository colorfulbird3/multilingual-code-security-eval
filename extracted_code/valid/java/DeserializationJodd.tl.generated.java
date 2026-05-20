package com.example.datahandler.service;

import java.util.Map;
import jodd.json.JsonParser;

public class WorkFlowService {
    public Map loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(jsonConfig, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }
}