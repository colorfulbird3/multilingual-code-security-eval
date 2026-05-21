package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

public class YamlService {

    /**
     * Parses the provided YAML content and returns the corresponding object.
     *
     * @param yamlContent The YAML string content to be parsed.
     * @return The object representation of the YAML content.
     * @throws IllegalArgumentException If the YAML content is invalid or cannot be parsed.
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML content cannot be null or empty");
        }

        try {
            Yaml yaml = new Yaml(new Constructor());
            return yaml.load(yamlContent);
        } catch (YAMLException e) {
            throw new IllegalArgumentException("Failed to parse YAML content", e);
        }
    }
}