package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Template service class for handling user profile page template rendering
 */
public class TemplateService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateService.class);
    
    private final Configuration freemarkerConfig;
    
    public TemplateService() {
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        this.freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "");
        this.freemarkerConfig.setDefaultEncoding("UTF-8");
    }
    
    /**
     * Renders the user profile page based on username and template content
     * 
     * @param username the username
     * @param templateContent the user-provided template content
     * @return the rendered HTML string
     */
    public String renderUserProfile(String username, String templateContent) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
            throw new IllegalArgumentException("Username and template content cannot be empty");
        }
        
        try {
            Template template = new Template("userProfile", templateContent, freemarkerConfig);
            
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);
            
            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            
            return writer.toString();
            
        } catch (IOException e) {
            LOGGER.error("IO exception occurred during template processing: " + e.getMessage(), e);
        } catch (TemplateException e) {