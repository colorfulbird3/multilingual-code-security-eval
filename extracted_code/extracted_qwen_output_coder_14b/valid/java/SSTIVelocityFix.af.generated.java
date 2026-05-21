package com.example.service;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.ResourceManager;
import org.apache.velocity.runtime.resource.ResourceManagerImpl;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader.StringResourceRepository;

import java.io.StringWriter;
import java.util.Properties;

/**
 * Velocity template service class for rendering user-customized dashboards
 */
public class VelocityTemplateService {

    private static final VelocityEngine velocityEngine;

    static {
        Properties props = new Properties();
        props.setProperty(RuntimeConstants.RESOURCE_LOADER, "string");
        props.setProperty("string.resource.loader.class", StringResourceLoader.class.getName());
        velocityEngine = new VelocityEngine(props);
        velocityEngine.init(props);
    }

    /**
     * Renders a user's personalized dashboard based on the user ID and dashboard template
     *
     * @param userId User ID
     * @param dashboardTemplate Velocity template content provided by the user
     * @return Rendered HTML string
     */
    public String renderUserDashboard(String userId, String dashboardTemplate) {
        if (userId == null || dashboardTemplate == null || dashboardTemplate.trim().isEmpty()) {
            return "<div>Template content or user ID is empty. Please check your input.</div>";
        }

        try {
            Context context = new VelocityContext();
            context.put("userId", userId);

            StringResourceRepository repo = ((StringResourceLoader) velocityEngine
                    .getApplicationAttribute(StringResourceLoader.VELOCITY_STRING_RESOURCE_LOADER)).getStringResourceRepository();

            repo.putStringResource("user_dashboard", dashboardTemplate);

            Template template = velocityEngine.getTemplate("user_dashboard");

            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            return writer.toString();
        } catch (Exception e) {
            return "<div>An error occurred while rendering the template: " + e.getMessage() + "</div>";
        }
    }
}