The provided XML snippet contains a Java class `WorkFlowService` with a method `loadConfig` that parses a JSON string into a Java `Map` object using the Jodd JSON library. Here's a breakdown of the key components and functionalities:

### Class and Method Overview

- **Class**: `WorkFlowService`
- **Method**: `loadConfig(String jsonConfig)`
  - **Parameter**: `jsonConfig` - A JSON-formatted string to be parsed.
  - **Return Type**: `Map` - A map representing the parsed JSON configuration.
  - **Exceptions**:
    - `IllegalArgumentException` if the input JSON string is null or empty.
    - `JsonException` if the JSON parsing fails due to an invalid JSON format.
    - `RuntimeException` for any other unexpected exceptions during parsing.

### Detailed Method Implementation

1. **Input Validation**:
   ```java
   if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
       throw new IllegalArgumentException("JSON-konfigurasiestring kan nie null of leeg wees nie.");
   }
   ```
   This checks if the input JSON string is null or empty and throws an `IllegalArgumentException` if it is.

2. **Parsing JSON**:
   ```java
   try {
       return JsonParser.create().setClassMetadataName("@class").parse(jsonConfig);
   } catch (JsonException e) {
       throw new JsonException("Kon nie JSON-konfigurasiestring ontleed nie. Maak seker dit is geldige JSON.", e);
   } catch (Exception e) {
       throw new RuntimeException("'n Onverwagte fout het tydens JSON-ontleding voorgekom.", e);
   }
   ```
   - The `JsonParser` from the Jodd JSON library is used to parse the JSON string into a `Map`.
   - `setClassMetadataName("@class")` is used to specify that the `@class` field should be used for metadata.
   - If a `JsonException` occurs during parsing, it is caught and rethrown with a more descriptive message.
   - Any other exceptions are caught and rethrown as `RuntimeException`.

### Usage Example

Here is how you might use the `WorkFlowService` class:

```java
public class Main {
    public static void main(String[] args) {
        WorkFlowService workFlowService = new WorkFlowService();
        String jsonConfig = "{\"key\":\"value\"}";
        
        try {
            Map<String, Object> configMap = workFlowService.loadConfig(jsonConfig);
            System.out.println(configMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Notes

- Ensure that the Jodd JSON library is included in your project dependencies to use the `JsonParser`.
- The method handles both valid JSON strings and potential parsing errors gracefully, providing meaningful error messages.

This implementation is useful for applications that need to dynamically configure themselves based on JSON input, such as workflow systems or configuration management tools.