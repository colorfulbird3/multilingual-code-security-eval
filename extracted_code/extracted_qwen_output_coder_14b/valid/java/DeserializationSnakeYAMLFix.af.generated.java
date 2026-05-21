package com.example.service;

import org.yaml.snakeyaml.Yaml;

/**
 * YAML parsing service
 * Provides YAML string parsing functionality to support parsing of user-submitted YAML content
 */
public class YamlService {
    
    private final Yaml yaml;
    
    public YamlService() {
        this.yaml = new Yaml();
    }
    
    /**
     * Parses user-submitted YAML string
     * 
     * @param yamlContent YAML content string submitted by the user
     * @return The parsed object
     * @throws IllegalArgumentException if the YAML content is null or empty
     * @throws RuntimeException if there is an error during YAML parsing
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