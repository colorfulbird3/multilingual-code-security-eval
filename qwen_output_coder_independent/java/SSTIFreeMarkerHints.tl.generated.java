```xml
<result>
    <code>
        <path>src/main/java/com/example/service/TemplateService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateService {

    private Configuration configuration;

    public TemplateService() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
    }

    public String renderUserProfile(String username, String templateContent) throws IOException, TemplateException {
        Template template = new Template("userProfile", new StringReader(templateContent), configuration);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        StringWriter out = new StringWriter();
        template.process(dataModel, out);

        return out.toString();
    }
}
            ]]>
        </content>
    </code>
</result>
```