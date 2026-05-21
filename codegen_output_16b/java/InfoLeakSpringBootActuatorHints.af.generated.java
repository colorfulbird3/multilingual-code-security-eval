aat:

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

Dit is een standaard-uitvoerformaat waarop we kunnen configureer die webtoepassing:

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

## Oplossing

- Voer `Application.java` uit.
- Voer `ApplicationWebConfig.java` uit.
- Voer `ApplicationProperties.java` uit.

### Lêerinhoud

- `src/main/java/com/example/core/controller/DateController.java`
```java
package com.example.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {
    @RequestMapping("/date")
    public String date(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
```

- `src/main/java/com/example/core/Application.java`
```java
package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class to start the Spring Boot service.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
- `src/main/java/com/example/core/ApplicationWebConfig.java`
```java
package com.example.core;

import org.spring