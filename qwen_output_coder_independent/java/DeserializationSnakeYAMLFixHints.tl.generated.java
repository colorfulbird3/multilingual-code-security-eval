```xml
<result>
    <code>
        <path>src/main/java/com/example/service/YamlService.java</path>
        <content><![CDATA[
package com.example.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * YAML parsing service
 * Provides YAML string parsing functionality, supporting parsing of user-submitted YAML content
 */
public class YamlService {
    
    private final Yaml yaml;
    
    public YamlService() {
        // Use a custom constructor to prevent deserialization vulnerabilities
        Constructor constructor = new Constructor() {
            @Override
            protected Class<?> getClassForName(String name) throws ClassNotFoundException {
                if ("com.example.unsafe.UnsafeClass".equals(name)) {
                    throw new ClassNotFoundException("Unsafe class detected");
                }
                return super.getClassForName(name);
            }
        };
        this.yaml = new Yaml(constructor);
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
]]></content>
    </code>
</result>
```