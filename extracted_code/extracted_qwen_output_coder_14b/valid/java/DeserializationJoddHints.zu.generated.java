package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonUtil;

import java.util.Map;

public class WorkFlowService {

    public Map<String, Object> loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            Map<String, Object> configMap = parser.parse(jsonConfig).toMap();
            return configMap;
        } catch (Exception e) {
            System.out.println("Error parsing JSON configuration: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        WorkFlowService service = new WorkFlowService();
        String jsonConfig = "{\"path\":\"path1\",\"content\":\"content1\"}";
        Map<String, Object> config = service.loadConfig(jsonConfig);
        if (config != null) {
            System.out.println("Configuration loaded successfully: " + JsonUtil.toJson(config));
        } else {
            System.out.println("Failed to load configuration.");
        }
    }
}