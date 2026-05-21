package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private final Configuration configuration;

    public TemplateService() {
        this.configuration = new Configuration(Configuration.VERSION_2_3_31);
        this.configuration.setClassForTemplateLoading(this.getClass(), "/");
    }

    public String renderUserProfile(String username, String templateContent) throws IOException, TemplateException {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        try (StringReader stringReader = new StringReader(templateContent);
             StringWriter stringWriter = new StringWriter()) {

            Template template = new Template("userProfileTemplate", stringReader, configuration);
            template.process(dataModel, stringWriter);

            return stringWriter.toString();
        }
    }
}