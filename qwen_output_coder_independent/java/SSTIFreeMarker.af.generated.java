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
        if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
            throw new IllegalArgumentException("Username and template content must not be blank");
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

### Uitleg

1. **Configuration**: Die `Configuration` klasse van Freemarker word gebruikt om die bladsjabloon-configurasyon te instel. Hier word die versie van Freemarker ingestel en die pad waar die bladsjablone lê word gespesifiseer.

2. **renderUserProfile Methode**: Hier word 'n bladsjabloon verwerk en die weergegewe HTML teruggegee.
   - **Parameters**: `username` en `templateContent`.
   - **Validering**: Word gecontroleer of die parameters nie leeg of `null` is.
   - **Template**: 'n `Template` object word gecreeër met die gegee bladsjablooninhoud.
   - **Data Model**: 'n `Map` word gecreeër om die gebruikersnaam toe te voeg.
   - **Verwerking**: Die bladsjabloon word verwerk met die gegee data model en die resultaat word weggeskryf na 'n `StringWriter`.

3. **StringWriter**: Dit word gebru