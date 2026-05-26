```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/TemplateService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    public String renderUserProfile(String username, String templateContent) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(this.getClass(), "/");

        try {
            Template template = new Template("userProfileTemplate", new StringReader(templateContent), cfg);
            StringWriter out = new StringWriter();
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);
            template.process(dataModel, out);
            return out.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("Error rendering template", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```