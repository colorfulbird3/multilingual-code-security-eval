package com.example.service;

import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class YamlService {

    public Object parseUserYaml(String yamlContent) {
        try {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(yamlContent);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        YamlService service = new YamlService();
        String yamlContent = "name: John Doe\nage: 30";
        Object result = service.parseUserYaml(yamlContent);
        System.out.println(result);
    }
}