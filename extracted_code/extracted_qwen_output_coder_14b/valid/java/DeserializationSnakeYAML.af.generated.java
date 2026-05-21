package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

public class YamlService {

    /**
     * Parses the provided YAML content into an object.
     *
     * @param yamlContent The YAML string to be parsed.
     * @return The parsed object representing the YAML content.
     * @throws IllegalArgumentException if the YAML content is invalid.
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.isEmpty()) {
            throw new IllegalArgumentException("YAML content cannot be null or empty.");
        }

        Yaml yaml = new Yaml(new Constructor(Object.class));
        try {
            return yaml.load(yamlContent);
        } catch (YAMLException e) {
            throw new IllegalArgumentException("Invalid YAML format.", e);
        }
    }
}