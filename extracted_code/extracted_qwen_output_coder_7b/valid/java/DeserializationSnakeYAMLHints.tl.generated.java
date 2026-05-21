package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YamlParseException;

public class YamlService {
    public Object parseUserYaml(String yamlContent) {
        try {
            Yaml yaml = new Yaml();
            return yaml.load(yamlContent);
        } catch (YamlParseException e) {
            throw new RuntimeException("Error parsing YAML content", e);
        }
    }
}