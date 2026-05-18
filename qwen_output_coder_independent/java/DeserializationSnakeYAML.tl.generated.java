```java
package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YamlException;

public class YamlService {

    /**
     * Parses the user-provided YAML content.
     *
     * @param yamlContent The YAML content to be parsed.
     * @return The parsed object.
     */
    public Object parseUserYaml(String yamlContent) {
        Yaml yaml = new Yaml();
        try {
            return yaml.load(yamlContent);
        } catch (YamlException e) {
            // Handle parsing exceptions appropriately
            throw new RuntimeException("Error parsing YAML content", e);
        }
    }
}
```

This code defines a `YamlService` class with a `parseUserYaml` method that takes a YAML content string as input and returns the parsed object using the SnakeYAML library. It also includes proper error handling for parsing exceptions.