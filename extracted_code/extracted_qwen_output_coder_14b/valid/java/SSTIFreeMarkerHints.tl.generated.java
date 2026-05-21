package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    public String renderUserProfile(String username, String templateContent) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
            throw new IllegalArgumentException("Username and template content cannot be null or empty");
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(this.getClass(), "/");

        try {
            Template template = new Template("profileTemplate", new StringReader(templateContent), cfg);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);

            Writer out = new StringWriter();
            template.process(dataModel, out);

            return out.toString();
        } catch (TemplateException | IOException e) {
            throw new RuntimeException("Error rendering user profile template", e);
        }
    }
}