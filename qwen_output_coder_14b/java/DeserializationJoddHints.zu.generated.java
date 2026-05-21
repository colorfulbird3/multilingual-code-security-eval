```java
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
```

In this solution, we have implemented the `loadConfig` method in the `WorkFlowService` class. This method takes a JSON configuration string as input and attempts to parse it using Jodd's `JsonParser`. The parsed JSON is then converted into a `Map<String, Object>` which is returned. If an exception occurs during parsing, an error message is printed and `null` is returned.

The `main` method demonstrates how to use the `loadConfig` method. It creates an instance of `WorkFlowService`, defines a JSON configuration string, and calls `loadConfig` with this string. If the configuration is loaded successfully, it prints the configuration details; otherwise, it prints a failure message.