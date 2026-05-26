```java
package com.example.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

/**
 * Service for rendering Velocity templates with custom data.
 */
public class VelocityTemplateService {

    private final VelocityEngine velocityEngine;

    public VelocityTemplateService() {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    /**
     * Renders a Velocity template with the given data.
     *
     * @param templateName the name of the template file (e.g., "dashboard.vm")
     * @param data         the data to populate the template
     * @return the rendered string
     */
    public String renderTemplate(String templateName, Map<String, Object> data) {
        Template template = velocityEngine.getTemplate(templateName);
        VelocityContext context = new VelocityContext(data);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

    /**
     * Renders a Velocity template with custom dashboard content.
     *
     * @param templateName the name of the template file
     * @param dashboardData the dashboard-specific data (charts, tables, etc.)
     * @return the rendered HTML string
     */
    public String renderDashboard(String templateName, DashboardData dashboardData) {
        Template template = velocityEngine.getTemplate(templateName);
        VelocityContext context = new VelocityContext();
        context.put("dashboard", dashboardData);
        context.put("charts", dashboardData.getCharts());
        context.put("tables", dashboardData.getTables());
        context.put("statistics", dashboardData.getStatistics());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

    /**
     * Inner class representing dashboard data.
     */
    public static class DashboardData {
        private Map<String, Object> charts;
        private Map<String, Object> tables;
        private Map<String, Object> statistics;

        public DashboardData(Map<String, Object> charts, Map<String, Object> tables, Map<String, Object> statistics) {
            this.charts = charts;
            this.tables = tables;
            this.statistics = statistics;
        }

        public Map<String, Object> getCharts() {
            return charts;
        }

        public Map<String, Object> getTables() {
            return tables;
        }

        public Map<String, Object> getStatistics() {
            return statistics;
        }
    }
}
```