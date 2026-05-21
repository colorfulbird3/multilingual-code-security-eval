package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private Configuration freemarkerConfig;

    public TemplateService() {
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
    }

    public String renderUserProfile(String username, String templateContent) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (StringUtils.isEmpty(templateContent)) {
            throw new IllegalArgumentException("Template content cannot be null or empty");
        }

        try {
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);

            Template template = new Template("userProfileTemplate", templateContent, freemarkerConfig);
            Writer out = new StringWriter();
            template.process(dataModel, out);

            return out.toString();
        } catch (TemplateException | java.io.IOException e) {
            throw new RuntimeException("Failed to render user profile template", e);
        }
    }

    public static void main(String[] args) {
        TemplateService service = new TemplateService();
        String username = "JohnDoe";
        String templateContent = "<h1>Welcome ${username}!</h1><p>This is your user profile page.</p>";

        String renderedTemplate = service.renderUserProfile(username, templateContent);
        System.out.println(renderedTemplate);
    }
}