package com.example.service;

import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class YamlService {

    public Object parseUserYaml(String yamlContent) {
        Yaml yaml = new Yaml();
        return yaml.load(yamlContent);
    }
}