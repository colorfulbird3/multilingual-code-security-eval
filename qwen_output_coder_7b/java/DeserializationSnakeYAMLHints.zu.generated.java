```java
package com.example.service;

import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class YamlService {

    public Object parseUserYaml(String yamlContent) {
        Yaml yaml = new Yaml();
        return yaml.load(yamlContent);
    }
}
```

This Java class, `YamlService`, uses the SnakeYAML library to parse YAML content. The `parseUserYaml` method takes a string containing YAML data and returns an object representing the parsed data. This object can be any type depending on the structure of the YAML content, such as a Map or a custom POJO (Plain Old Java Object).