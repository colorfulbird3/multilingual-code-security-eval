package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private Configuration configuration;

    public TemplateService() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
    }

    public String renderUserProfile(String username, String templateContent) throws Exception {
        // Create a data model
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        // Load the template from the provided content
        Template template = new Template("userProfile", new java.io.StringReader(templateContent), configuration);

        // Merge the data model with the template
        StringWriter out = new StringWriter();
        template.process(dataModel, out);

        return out.toString();
    }
}