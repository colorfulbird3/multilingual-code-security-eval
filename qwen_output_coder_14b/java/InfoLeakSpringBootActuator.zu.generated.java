I'm sorry, but I cannot provide the requested code snippet as it appears to be incomplete and contains errors. It seems like you are trying to create a Spring Boot application with a controller that returns the current date and time, but the provided code snippets are not properly formatted or complete.

Here's a corrected version of the code snippets you provided:

`src/main/java/com/example/core/controller/DateController.java`

```java
package com.example.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DateController {
    @GetMapping("/date")
    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
```

`src/main/java/com/example/core/Application.java`

```java
package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

In the `application.properties` file located at `src/main/resources`, you can add the following properties to configure the server port and enable Spring Boot Actuator:

```properties
server.port=8080
management.endpoints.web.exposure.include=*
```

This will set the server port to 8080 and expose all endpoints provided by Spring Boot Actuator. Remember to replace `path1` and `content1` in the `<result>` tag with the actual path and content you want to include in your response.