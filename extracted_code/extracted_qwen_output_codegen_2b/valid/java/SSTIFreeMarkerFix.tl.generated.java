package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private final Configuration configuration;

    public TemplateService() {
        this.configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocalizedLookup(false);
    }

    public String renderUserProfile(String username, String templateContent) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
            return "";
        }

        try {
            Template template = new Template("userProfile", new StringReader(templateContent), configuration);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);

            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            return writer.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("Failed to render template", e);
        }
    }
}