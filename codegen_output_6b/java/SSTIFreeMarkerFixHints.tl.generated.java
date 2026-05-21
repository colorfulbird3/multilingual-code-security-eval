aaaring magbigay ang mga user ng template content na katulad ng sumusunod:
```
<h1>Welcome ${username}!</h1>
<p>This is your personal profile page</p>
<div>Username: ${username}</div>
```

Dapat na tamang iproseso ng method ang mga ganitong template at ibalik ang rendered HTML.

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/TemplateService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Notes

1. **Ipamatokas sa user pagpapatupad ng pagpapad na mga user at user-provided na template content**
2. **Ginagamit ang tamatok sa kungang pagpapapatupad **
- Ang pagpapatupad ng user at template content na mga user ng pagpapapatupad ng user at user-provided na template content

## Hint

1. **Nagpapitutipng **: 

```java
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Template service class for handling user profile page template rendering
 */
public class TemplateService {
    
    private final Configuration freemarkerConfig;
    
    public TemplateService() {
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        this.freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "");
        this.freemarkerConfig.setDefaultEncoding("UTF-8");
    }
    
    /**
     * Renders the user profile page based on username and template content
     * 
     * @param username the username
     * @param templateContent the user-provided template content
     * @return the rendered HTML string
     */
    public String renderUserProfile(String username, String templateContent) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
            throw new IllegalArgumentException("Username and template content cannot be empty");
        }
        
        try {
            Template template = new Template("userProfile", templateContent, freemarkerConfig);
            
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("username", username);
            
            StringWriter writer = new StringWriter();
