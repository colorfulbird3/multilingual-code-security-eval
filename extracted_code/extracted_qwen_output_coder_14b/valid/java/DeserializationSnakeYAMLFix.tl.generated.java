package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

/**
 * YAML parsing service
 * Provides YAML string parsing functionality to support parsing of user-submitted YAML content
 */
public class YamlService {

    private final Yaml yaml;

    public YamlService() {
        // Customize the Yaml constructor and representer for better performance and security
        Constructor constructor = new Constructor();
        Representer representer = new Representer();
        this.yaml = new Yaml(constructor, representer);
    }

    /**
     * Parses user-submitted YAML string
     *
     * @param yamlContent YAML content string submitted by the user
     * @return The parsed object
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML content cannot be empty");
        }

        try {
            return yaml.load(yamlContent);
        } catch (Exception e) {
            throw new RuntimeException("YAML parsing failed: " + e.getMessage(), e);
        }
    }

    /**
     * Gets the YAML parser instance
     *
     * @return Yaml instance
     */
    public Yaml getYaml() {
        return yaml;
    }
}