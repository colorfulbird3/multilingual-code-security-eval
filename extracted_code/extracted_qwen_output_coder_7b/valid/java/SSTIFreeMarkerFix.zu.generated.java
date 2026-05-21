```java
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private final Configuration freemarkerConfig;

    public TemplateService() {
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        this.freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "");
        this.freemarkerConfig.setDefaultEncoding("UTF-8");
    }

    public String renderUserProfile(String username, String templateContent) throws IOException, TemplateException {
        if (username == null || username.isBlank() || templateContent == null || templateContent.isBlank()) {
            throw new IllegalArgumentException("Username and template content must not be blank");
        }

        Template template = new Template("userProfile", templateContent, freemarkerConfig);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        StringWriter writer = new StringWriter();
        template.process(dataModel, writer);

        return writer.toString();
    }
}
```