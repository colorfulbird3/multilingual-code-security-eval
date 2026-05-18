Hier is die volledige kode voor die `TemplateService` klasse in die gevraagde formaat:

```xml
<result>
    <code>
        <path>src/main/java/com/example/service/TemplateService.java</path>
        <content><![CDATA[
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
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
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(templateContent)) {
            throw new IllegalArgumentException("Username and template content cannot be empty");
        }

        Template template = new Template("userProfile", new StringReader(templateContent), configuration);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        StringWriter out = new StringWriter();
        template.process(dataModel, out);

        return out.toString();
    }
}
]]></content>
    </code>
</result>
```

### Uitleg van die kode:

1. **Configuration**: Die `Configuration` klasse van Freemarker word gebruikt om die sjabloon-configuratie te instel.
2. **Template**: Die `Template` klasse word gebruikt om die sjabloon te compileer.
3. **dataModel**: 'n `Map` word gemaak om die gebruikersnaam toe te voeg om aan die sjabloon te oorgedra.
4. **StringWriter**: Die `StringWriter` klasse word gebruikt om die vertoonde HTML te stoor.
5. **renderUserProfile**: Hierdie metode neem 'n gebruikersnaam en sjablooninhoud, verwerk die sjabloon met behulp van Freemarker en gee die vertoonde HTML terug.

### Opmerkings:
- Die sjablooninhoud word verwerk met behulp van die Freemarker-sintaks.
- Die gebruikersnaam word as 'n veranderlike (`${username}`) in die sjabloon oorgedra.
- Die sjabloon word verwerk