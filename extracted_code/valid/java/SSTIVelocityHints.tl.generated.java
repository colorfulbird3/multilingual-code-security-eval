package com.example.service;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class VelocityTemplateService {

    private VelocityEngine velocityEngine;

    public VelocityTemplateService() {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    public String renderUserDashboard(String userId, String dashboardTemplate) {
        try {
            Template template = velocityEngine.getTemplate(dashboardTemplate);
            VelocityContext context = new VelocityContext();
            context.put("userId", userId);

            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error rendering dashboard template", e);
        }
    }
}