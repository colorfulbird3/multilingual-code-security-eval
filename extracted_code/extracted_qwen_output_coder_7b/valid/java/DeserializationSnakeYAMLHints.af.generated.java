package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YamlParseException;

public class YamlService {

    /**
     * Parses the user-provided YAML content and returns the parsed object.
     *
     * @param yamlContent The YAML content provided by the user.
     * @return The parsed object from the YAML content.
     */
    public Object parseUserYaml(String yamlContent) {
        try {
            Yaml yaml = new Yaml();
            return yaml.load(yamlContent);
        } catch (YamlParseException e) {
            throw new IllegalArgumentException("Invalid YAML content: " + e.getMessage(), e);
        }
    }

}