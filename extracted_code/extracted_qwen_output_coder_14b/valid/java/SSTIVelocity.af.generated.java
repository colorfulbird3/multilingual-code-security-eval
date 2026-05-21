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
        // Initialize the Velocity engine
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        try {
            velocityEngine.init();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Velocity engine", e);
        }
    }

    public String renderUserDashboard(String userId, String dashboardTemplate) {
        try {
            // Create a Velocity context and add the user ID to it
            VelocityContext context = new VelocityContext();
            context.put("userId", userId);

            // Parse the template string into a Template object
            Template template = velocityEngine.getTemplate(dashboardTemplate, "UTF-8");

            // Merge the template with the context
            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            // Return the rendered HTML string
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to render user dashboard", e);
        }
    }

    public static void main(String[] args) {
        VelocityTemplateService service = new VelocityTemplateService();
        String userId = "12345";
        String dashboardTemplate = "#set($user = $userId)\n" +
                                   "<div class=\"dashboard\">\n" +
                                   "    <h1>Welkom, gebruiker $user</h1>\n" +
                                   "    <div class=\"stats\">\n" +
                                   "        <p>Gebruikers-ID: $userId</p>\n" +
                                   "    </div>\n" +
                                   "</div>";

        String result = service.renderUserDashboard(userId, dashboardTemplate);
        System.out.println(result);
    }
}