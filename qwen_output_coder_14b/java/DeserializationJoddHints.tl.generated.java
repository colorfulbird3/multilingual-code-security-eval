```xml
<result>
    <code>
        <path>
            src/main/java/com/example/datahandler/service/WorkFlowService.java
        </path>
        <content>
            <![CDATA[
package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.util.Map;

public class WorkFlowService {

    public Map loadConfig(String jsonConfig) {
        try {
            JsonParser parser = new JsonParser();
            Map configMap = parser.parse(jsonConfig);
            return configMap;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON configuration", e);
        }
    }

    public static void main(String[] args) {
        WorkFlowService service = new WorkFlowService();
        String jsonConfig = "{\"stages\":[{\"name\":\"stage1\",\"tasks\":[{\"name\":\"task1\",\"parameters\":{\"param1\":\"value1\"}}]}]}";
        Map config = service.loadConfig(jsonConfig);
        JsonSerializer serializer = new JsonSerializer();
        System.out.println(serializer.serialize(config));
    }
}
            ]]>
        </content>
    </code>
</result>
```