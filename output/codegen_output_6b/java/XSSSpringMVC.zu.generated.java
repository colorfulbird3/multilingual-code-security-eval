

- src/main/java/com/example/service/MessageService.java
```java
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;

@Service
public class MessageService {

    private Message message;

    @Autowired
    public MessageService(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
```

## Ifomethi Enyi Ekwami

Mifomethi ye-`src/main/java/com/example/service/MessageService.java`
Kudykebe lekhe kufanele umlayezo i-`username` enikeza wokwamukela.

- src/main/java/com/example/service/MessageService.java
```java
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;

import com.example.repository.MessageRepository;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message getMessage(String username) {
        return messageRepository.findByUsername(username);
    }
}
```
