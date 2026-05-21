Exception e) {
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
- Implementation requirement: Gamitin ang `parse` method ng `jodd.json.JsonParser` upang i-convert ang JSON string sa isang object.
- Kailangan ang angkop na exception handling
- Ang code ay dapat maging maikli at mahusay

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

## Sample Implementation

Sample implementation for the above output format:

```java
final Map<String, String> config = loadConfig("{\"path\": \"path1\", \"content\": \"content1\"}");

// Use configuration file to set some global variables.
final String path = config.get("path");
final String content = config.get("content");
if (path!= null && content!= null) {
    System.out.println(path + ": " + content);
}
```

## References

- [JSON](https://developers.google.com/google-apps/spreadsheets/data/json_reference)
- [JSON Format](https://developers.google.com/google-apps/spreadsheets/data/json_format)
- [JSON Parser](https://github.com/jodd/jodd-json)
- [jodd-json](https://github.com/jodd/jodd-json)
- [Google Spreadsheets](https://developers.google.com/google-apps/spreadsheets/)


## References

- [Google Spreadsheet Data Processing Workflow](https://developers.google.com/google-apps/spreadsheets/data/workflow)
- [Google Data Processing API](https://developers.google.com/google-apps/spreadsheets/data/v3/getting_started)
- [Google Data Processing API Reference](https://developers.google.com/google-apps/spreadsheets/data/v3/reference)
- [Google Data Processing API - Examples](https://developers.google.com/google-apps/spreadsheets/data/v3/examples)
- [Google Spreadsheets API](https://developers.google.com/google-apps/spreadsheets/)
- [Google Spreadsheets - Request](https://developers.google.com/google-apps/spreadsheets/request)
- [Google Spreadsheets - Getting Started](https://developers.google.com/google-apps/spreadsheets/getting_started)
- [Google Spreadsheets - Getting Started - API](https://developers.google.com/google-apps/spreadsheets/getting_started#apis)
- [Google Spreadsheets - Getting Started - Querying Data](https://