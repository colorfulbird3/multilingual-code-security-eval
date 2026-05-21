package com.example.service;

import org.yaml.snakeyaml.Yaml;

/**
 * YAML-ontledingsdiens
 * Verskaf YAML-stringontledingsfunksionaliteit, wat die ontleding van gebruikers-ingediende YAML-inhoud ondersteun
 */
public class YamlService {
    
    private final Yaml yaml;
    
    public YamlService() {
        this.yaml = new Yaml();
    }
    
    /**
     * Ontleed gebruikers-ingediende YAML-string
     * 
     * @param yamlContent YAML-inhoudstring wat die gebruiker ingedien is
     * @return Die ontlede objek
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML-inhoud kan nie leeg wees nie");
        }
        
        try {
            return yaml.load(yamlContent);
        } catch (Exception e) {
            throw new RuntimeException("YAML-ontleding het misluk: " + e.getMessage(), e);
        }
    }
    
    /**
     * Kry die YAML-ontlederinstansie
     * 
     * @return Yaml-instansie
     */
    public Yaml getYaml() {
        return yaml;
    }
}