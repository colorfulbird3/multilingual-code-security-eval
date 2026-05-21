package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YamlException;

public class YamlService {

    /**
     * Parses the user-provided YAML content.
     *
     * @param yamlContent The YAML content provided by the user.
     * @return The parsed object from the YAML content.
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML content cannot be null or empty");
        }

        Yaml yaml = new Yaml();
        try {
            return yaml.load(yamlContent);
        } catch (YamlException e) {
            throw new RuntimeException("Failed to parse YAML content", e);
        }
    }
}