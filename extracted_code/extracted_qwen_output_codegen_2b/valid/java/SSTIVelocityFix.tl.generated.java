```java
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.MethodInvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VelocityTemplateService {
    private static final Logger logger = LoggerFactory.getLogger(VelocityTemplateService.class);
    private final VelocityEngine velocityEngine;
    private final ConcurrentHashMap<String, Template> templateCache;

    public VelocityTemplateService() {
        this.velocityEngine = new VelocityEngine();
        this.templateCache = new ConcurrentHashMap<>();
        initializeVelocityEngine();
    }

    private void initializeVelocityEngine() {
        try {
            velocityEngine.setProperty("resource.loader", "class");
            velocityEngine.setProperty("class.resource.loader.class", 
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            velocityEngine.setProperty("runtime.log.logsystem.class", 
                "org.apache.velocity.runtime.log.NullLogChute");
            velocityEngine.setProperty("input.encoding", "UTF-8");
            velocityEngine.setProperty("output.encoding", "UTF-8");
            velocityEngine.setProperty("velocimacro.library", "");
            velocityEngine.setProperty("runtime.strict_mode.enable", true);
            velocityEngine.init();
            logger.info("Velocity engine initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize Velocity engine: {}", e.getMessage());
            throw new RuntimeException("Velocity engine initialization failed", e);
        }
    }

    public String processTemplate(String templateName, Map<String, Object> contextData) {
        if (templateName == null || templateName.isEmpty()) {
            throw new IllegalArgumentException("Template name cannot be null or empty");
        }
        if (contextData == null) {
            throw new IllegalArgumentException("Context data cannot be null");
        }

        StringWriter writer = new StringWriter();
        try {
            Template template = getTemplate(templateName);
            VelocityContext context = createVelocityContext(contextData);
            template.merge(context, writer);
            logger.debug("Template '{}' processed successfully", templateName);
            return writer.toString();
        } catch (ResourceNotFoundException e) {
            logger.error("Template '{}' not found: {}", templateName, e.getMessage());
            throw new RuntimeException("Template not found: " + templateName, e);
        } catch (ParseErrorException e) {
            logger.error("Parse error in template '{}': {}", templateName, e.getMessage());
            throw new RuntimeException("Template parse error: " + templateName, e);
        } catch (MethodInvocationException e) {
            logger.error("Method invocation error in template '{}': {}", templateName, e.getMessage());
            throw new RuntimeException("Template method invocation error: " + templateName, e);
        } catch (Exception e) {
            logger.error("Unexpected error processing template '{}': {}", templateName, e.getMessage());
            throw new RuntimeException("Template processing failed: " + templateName, e);
        }
    }

    private Template getTemplate(String templateName) {
        return templateCache.computeIfAbsent(templateName, name -> {
            try {
                Template template = velocityEngine.getTemplate(name);
                logger.debug("Template '{}' loaded and cached", name);
                return template;
            } catch (Exception e) {
                logger.error("Failed to load template '{}': {}", name, e.getMessage());
                throw new RuntimeException("Failed to load template: " + name, e);
            }
        });
    }

    private VelocityContext createVelocityContext(Map<String, Object> contextData) {
        VelocityContext context = new VelocityContext();
        if (contextData != null) {
            contextData.forEach(context::put);
        }
        return context;
    }

    public void clearTemplateCache() {
        templateCache.clear();
        logger.info("Template cache cleared");
    }

    public void removeTemplateFromCache(String templateName) {
        templateCache.remove(templateName);
        logger.debug("Template '{}' removed from cache", templateName);
    }
}
```