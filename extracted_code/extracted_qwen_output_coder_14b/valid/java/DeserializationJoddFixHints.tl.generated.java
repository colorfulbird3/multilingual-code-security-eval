package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonException;
import java.util.Map;

public class WorkFlowService {

    /**
     * Parses a JSON format string into a Java Map object using jodd-json library.
     * This method handles arbitrary legal JSON structures and returns them as a Map.
     *
     * @param jsonConfig The JSON format string to be parsed.
     * @return A Map object representing the parsed JSON configuration.
     * @throws JsonException if the input string is not a valid JSON format or parsing fails.
     */
    public Map loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration string cannot be null or empty.");
        }

        try {
            // Use jodd.json.JsonParser to parse the JSON string to an object,
            // which will be a Map for the top-level JSON object.
            return JsonParser.create().parse(jsonConfig);
        } catch (JsonException e) {
            // Catch JSON parsing specific exceptions and re-throw with a more informative message.
            throw new JsonException("Failed to parse JSON configuration string. Please ensure it is valid JSON.", e);
        } catch (Exception e) {
            // Catch any other unexpected exceptions during parsing.
            throw new RuntimeException("An unexpected error occurred during JSON parsing.", e);
        }
    }
}