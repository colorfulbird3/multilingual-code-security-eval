

- src/main/java/com/example/service/MessageService.java
```java
package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;

@RestController
@RequestMapping("/message")
public class MessageService {

    private static final String template = "Hello, %s!";

    @RequestMapping("/welcome")
    public WelcomeMessage welcome(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new WelcomeMessage(String.format(template, name));
    }
}

```

## Okuqinqwe Okuphebele

- src/main/java/com/example/message/WelcomeMessage.java
```java
package com.example.message;

import java.io.Serializable;

public class WelcomeMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;

    public WelcomeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```
