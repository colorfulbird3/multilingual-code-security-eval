package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    public String renderUserProfile(String username, String templateContent) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");

        try {
            Template template = new Template("profileTemplate", new StringReader(templateContent), cfg);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);

            Writer out = new StringWriter();
            template.process(dataModel, out);
            return out.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to render user profile", e);
        }
    }
}