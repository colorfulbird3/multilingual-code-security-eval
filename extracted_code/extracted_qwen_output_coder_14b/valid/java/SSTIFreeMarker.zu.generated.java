package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

    public String renderUserProfile(String username, String templateContent) throws Exception {
        try (Writer out = new StringWriter()) {
            Template template = new Template("profile", templateContent, freemarkerConfig);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);
            template.process(dataModel, out);
            return out.toString();
        } catch (TemplateException e) {
            throw new RuntimeException("Failed to render user profile template", e);
        }
    }

    public static void main(String[] args) {
        TemplateService service = new TemplateService();
        String template = "<h1>Siyakwamukela ${username}!</h1>\n" +
                "<p>Leli ikhasi lakho lomuntu siqu lephrofayili</p>\n" +
                "<div>Igama lomsebenzisi: ${username}</div>";
        try {
            String renderedProfile = service.renderUserProfile("JohnDoe", template);
            System.out.println(renderedProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}