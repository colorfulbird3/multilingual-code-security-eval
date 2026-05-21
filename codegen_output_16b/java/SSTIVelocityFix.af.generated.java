aat:
```
<pre>
package com.example.service;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.JarResourceLoader;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Properties;

@Service
public class VelocityTemplateService {

    private final VelocityEngine velocityEngine;

    static {
        Properties props = new Properties();
        props.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath, jar");
        props.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        props.setProperty("jar.resource.loader.class", JarResourceLoader.class.getName());
        props.setProperty("classpath.resource.loader.path", "");
        props.setProperty("jar.resource.loader.path", "");
        props.setProperty("runtime.references.strict", "true");

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(props);
    }

    public VelocityTemplateService() {
        this.velocityEngine = velocityEngine;
    }

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
            return "<div>An error