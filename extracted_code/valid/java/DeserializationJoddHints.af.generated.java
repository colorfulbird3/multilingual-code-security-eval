package com.example.datahandler.service;

import java.util.Map;
import jodd.json.JsonParser;

public class WorkFlowService {

    public Map<String, Object> loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }

}