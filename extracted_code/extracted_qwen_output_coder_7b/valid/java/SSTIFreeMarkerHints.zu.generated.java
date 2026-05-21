package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.StringWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private Configuration configuration;

    public TemplateService() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);
    }

    public String renderUserProfile(String username, String templateContent) {
        try {
            Template template = new Template("userProfile", templateContent, configuration);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);
            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            return writer.toString();
        } catch (TemplateException | IOException e) {
            throw new RuntimeException("Failed to render template", e);
        }
    }
}