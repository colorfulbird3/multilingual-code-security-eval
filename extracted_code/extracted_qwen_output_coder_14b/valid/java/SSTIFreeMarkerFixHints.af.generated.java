package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private final Configuration configuration;

    public TemplateService() {
        this.configuration = new Configuration(Configuration.VERSION_2_3_31);
        this.configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        this.configuration.setDefaultEncoding("UTF-8");
    }

    public String renderUserProfile(String username, String templateContent) {
        if (username == null || username.isBlank() || templateContent == null || templateContent.isBlank()) {
            throw new IllegalArgumentException("Username and template content must not be blank");
        }

        try {
            Template template = new Template("userProfile", templateContent, configuration);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);

            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            return writer.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error processing template: " + e.getMessage(), e);
        } catch (TemplateException e) {
            throw new RuntimeException("Error processing template: " + e.getMessage(), e);
        }
    }
}