package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private Configuration configuration;

    public TemplateService() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
    }

    public String renderUserProfile(String username, String templateContent) throws IOException, TemplateException {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(templateContent)) {
            throw new IllegalArgumentException("Username and template content cannot be empty");
        }

        Template template = new Template("userProfile", new StringReader(templateContent), configuration);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        StringWriter out = new StringWriter();
        template.process(dataModel, out);

        return out.toString();
    }
}