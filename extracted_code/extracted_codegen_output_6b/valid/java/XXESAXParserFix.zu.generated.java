package com.example.service;

import java.io.*;
import java.util.*;

public class ConfigService {

    private Properties properties;

    public ConfigService() {
        properties = new Properties();
    }

    public void loadConfig(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Set<String> getPropertyNames() {
        return properties.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public int size() {
        return properties.size();
    }

    public void clear() {
        properties.clear();
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void saveConfig(String filePath) throws IOException {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        }
    }

    public Map<String, String> getAllProperties() {
        Map<String, String> map = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.getProperty(key));
        }
        return map;
    }
}