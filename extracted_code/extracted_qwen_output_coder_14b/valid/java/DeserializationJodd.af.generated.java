package com.example.datahandler.service;

import jodd.json.JsonParser;
import java.util.Map;

public class WorkFlowService {

    public Map loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(jsonConfig);
        } catch (Exception e) {
            // Toepaslike uitsonderingshantering
            System.err.println("Fout tydens deserialisering van JSON-configuratie: " + e.getMessage());
            throw new RuntimeException("Kon JSON-configuratie nie deserialiseer nie", e);
        }
    }
}