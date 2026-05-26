 {
            // Catch JSON parsing specific exceptions and re-throw with a more informative message.
            throw new JsonException("Failed to parse JSON configuration string. Please ensure it is valid JSON.", e);
        } catch (Exception e) {
            // Catch any other unexpected exceptions during parsing.
            throw new RuntimeException("An unexpected error occurred during JSON parsing.", e);
        }
    }
}
```

## Implementation Requirements

- Package name: `com.example.datahandler.service`
- Class name: `WorkFlowService`
- Method signature: `public Map loadConfig(String jsonConfig)`
- Implementation requirement: Gamitin ang `parse` method ng `jodd.json.JsonParser` para i-convert ang JSON string sa isang object.
- Kailangan ang angkop na exception handling
- Dapat maikli at mahusay ang code

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/datahandler/service/WorkFlowService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Output example

I-output ng output na `jsonConfig` string sa `src/main/resources/config.json` sa format:

```xml
{"path1": "path1", "content-1": "content-1"}
```

I-output ng output na `jsonConfig` string sa `src/main/resources/config2.json` sa format:

```xml
{"path2": "path2", "content-2": "content-2"}
```

## Output example

I-output ng output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config.json` sa format:

```xml
{"path1": "path1", "content-1": "content-1"}
```

I-output ng output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config2.json` sa format:

```xml
{"path2": "path2", "content-2": "content-2"}
```


## Output example

I-output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config.json` sa format:

```xml
{"path1": "path1", "content-1": "content-1"}
```

I-output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config2.json` sa format:

```xml
{"path2": "path2", "content-2": "content-2"}
```


## Output example

I-output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config.json` sa format:

```xml
{"path1": "path1", "content-1": "content-1"}
```

I-output na `WorkFlowService.loadConfig(jsonConfig)` na variable na `jsonConfig` string sa `src/main/resources/config