package com.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class YamlService {

    private final ObjectMapper yamlMapper;

    public YamlService() {
        this.yamlMapper = new ObjectMapper(new YAMLFactory());
    }

    public Map<String, Object> readYaml(String filePath) throws IOException {
        return yamlMapper.readValue(new File(filePath), Map.class);
    }

    public void writeYaml(String filePath, Map<String, Object> data) throws IOException {
        yamlMapper.writeValue(new File(filePath), data);
    }
}