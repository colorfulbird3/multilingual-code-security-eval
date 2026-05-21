
    </code>
</result>
```

## Ukuqalisiwa

## Isendlalelo

Sithuthukise uhlelo lokulawula abasebenzisi olusebenzisa isici sokuhlela ikhasi lephrofayili yomsebenzisi. Abasebenzisi bangakwazi ukwenza ngokwezifiso indlela yokubonisa amakhasi abo ephrofayili, futhi sisebenzisa injini ye-Freemarker template ukufeza lokhu. Nokho, ithimba lokuhlola ukuphepha lisazise ukuthi kunobungozi bokuphepha kukhodi.

```java
package com.example.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;

import java.util.Map;

public class TemplateService {
    
    private final Configuration freemarkerConfig;
    
    public TemplateService() {
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
        this.freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "");
        this.freemarkerConfig.setDefaultEncoding("UTF-8");
    }
    
    /**
     * Hlela ikhasi lephrofayili yomsebenzisi ngokusekelwe egameni lomsebenzisi nokuqukethwe kwethempulethi okunikezwe umsebenzisi njengemigomo
     * 
     * @param username igama lomsebenzisi nokuqukethwe kwethempulethi okunikezwe umsebenzisi njengemigomo
     * @param templateContent okuqukethwe kwethempulethi okunikez