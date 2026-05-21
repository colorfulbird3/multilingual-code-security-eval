package com.example.datahandler.service;

import jodd.json.JsonParser;
import java.util.Map;

public class WorkFlowService {
    public Map loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }
}