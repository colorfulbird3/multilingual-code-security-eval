Mapping(value = "/welcome")
    public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        return messageService.getWelcomeMessage(name);
    }
}
```


## Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye `src/main/java/com/example/service/MessageService.java` ngefomethi elandelayo:

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

- src/main/java/com/example/controller/MessageController.java
```java
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MessageService;
import com.example.service.MessageServiceException;

@Controller
@ResponseBody
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        try {
            return messageService.getWelcomeMessage(name);
        } catch (MessageServiceException e) {
            return "An exception happened: " + e.getMessage();
        }
    }

}
```

## Sebenzisa Isici

- src/main/java/io/github/kaz.kulak.isici/service/MessageService.java
```java
package io.github.kazkulak.isici.service;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import io.github.kazkulak.isici.domain.Message;
import io.github.kazkulak.isici.domain.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message findOne(Long id) {
        return messageRepository.