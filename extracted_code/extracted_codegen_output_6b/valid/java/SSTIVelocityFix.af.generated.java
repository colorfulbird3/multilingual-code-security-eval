import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTemplateService {

    private static final VelocityEngine velocityEngine;

    static {
        Properties props = new Properties();
        velocityEngine = new VelocityEngine();
        velocityEngine.init(props);
    }

    public String renderUserDashboard(String userId, String dashboardTemplate) {
        if (userId == null || dashboardTemplate == null || dashboardTemplate.trim().isEmpty()) {
            return "Template content or user ID is empty. Please check your input.";
        }

        try {
            Context context = new VelocityContext();
            context.put("userId", userId);

            StringWriter writer = new StringWriter();
            Template template = velocityEngine.getTemplate("user_dashboard.vm");
            template.merge(context, writer);

            return writer.toString();
        } catch (Exception e) {
            return "An error occurred while rendering the template: " + e.getMessage();
        }
    }
}