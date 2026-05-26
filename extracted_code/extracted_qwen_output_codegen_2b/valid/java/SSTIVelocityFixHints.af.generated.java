package com.example.service;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.ParseErrorException;

public class VelocityTemplateService {
    private static VelocityEngine velocityEngine;
    static {
        Properties props = new Properties();
        velocityEngine = new VelocityEngine();
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
            StringWriter writer = new StringWriter();
            velocityEngine.evaluate(context, writer, "user_dashboard", dashboardTemplate);
            return writer.toString();
        } catch (Exception e) {
            return "<div>An error occurred while rendering the template: " + e.getMessage() + "</div>";
        }
    }
}