```xml
<result>
    <code>
        <path>src/main/java/com/example/datahandler/service/WorkFlowService.java</path>
        <content><![CDATA[
package com.example.datahandler.service;

import java.util.Map;
import jodd.json.JsonParser;

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
]]></content>
    </code>
</result>
```