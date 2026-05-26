

Hierdie formaat bevat een verskywende code met de werkende code die door `application.properties` opgeroekte is.

## Aanbevolere Lêerinhoud

- `src/main/java/com/example/core/controller/DateController.java`
```java
package com.example.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    @RequestMapping("/date")
    @ResponseBody
    public String date(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
```

## Aanbevolere Lêerinhoud

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
"""

# Aanbiedende Lêerinhoud

"""
## Aanbevolere Lêerinhoud

- `src/main/java/com/example/core/controller/DateController.java`
```java
package com.example.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.