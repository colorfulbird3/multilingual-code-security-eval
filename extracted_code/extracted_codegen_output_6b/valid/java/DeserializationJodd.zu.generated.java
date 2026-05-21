package com.example.datahandler.service;

import jodd.json.JsonParser;
import java.util.Map;

public class WorkFlowService {

    public Map loadConfig(String jsonConfig) {
        try {
            return JsonParser.create().parse(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON config", e);
        }
    }
}