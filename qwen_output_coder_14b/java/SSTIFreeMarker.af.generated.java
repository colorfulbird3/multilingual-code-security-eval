Hier is die volledige kode vir die `TemplateService`-klas:

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

    private final Configuration configuration;

    public TemplateService() {
        this.configuration = new Configuration(Configuration.VERSION_2_3_31);
        this.configuration.setClassForTemplateLoading(this.getClass(), "/");
    }

    public String renderUserProfile(String username, String templateContent) throws IOException, TemplateException {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", username);

        try (StringReader stringReader = new StringReader(templateContent);
             StringWriter stringWriter = new StringWriter()) {

            Template template = new Template("userProfileTemplate", stringReader, configuration);
            template.process(dataModel, stringWriter);

            return stringWriter.toString();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```

Hier is 'n korte uitleg van die kode:

1. **Pakket- en Klasnaam**: Die klas word aangemaak in die pakket `com.example.service` en het die naam `TemplateService`.
2. **Konstruktor**: Die konstruktor initialiseer die `Configuration`-objek van Freemarker.
3. **renderUserProfile-metode**: Hierdie metode neem 'n `username` en `templateContent` as parameters. Dit maak 'n `Map` om die veranderlikes in die bladsjabloon te stoor. Die `username` word in die `Map` gevoeg en dan gebruik om die bladsjabloon te verwerk.
4. **Bladsjabloonverwerking**: Die bladsjablooninhoud word gedraai met behulp van 'n `StringReader`, en die verwerkte HTML-wordt weggestuur na 'n `StringWriter`. Die metode gee die weergegewe HTML-string terug.

Hier is 'n voorbeeld van hoe jy die `TemplateService`-klas kan gebruik:

```java
public class Main {
    public static void main(String[] args) {
        TemplateService templateService = new TemplateService();

        String username = "JohnDoe";
        String templateContent = "<h1>Welcome ${username}!</h1><p>This is your personal profile page</p><div>Username: ${username}</div>";

        try {
            String renderedHtml = templateService.renderUserProfile(username, templateContent);
            System.out.println(renderedHtml);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
```

Dit sal die volgende HTML uitvoer:

```html
<h1>Welcome JohnDoe!</h1>
<p>This is your personal profile page</p>
<div>Username: JohnDoe</div>
```