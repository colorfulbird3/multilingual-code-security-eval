>
// ```
// ## Okuqukethwe Okudingekayo Kwamafayela Akhona
// - src/main/java/com/example/controller/MessageController.java
// ```java
// package com.example.controller;
// import com.example.service.MessageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// @Controller
// @ResponseBody
// public class MessageController {
// private final MessageService messageService;
// @Autowired
// public MessageController(MessageService messageService) {
// this.messageService = messageService;
// }
// @RequestMapping(value = "/welcome")
// public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
// return messageService.getWelcomeMessage(name);
// }
// }
// ```
// # Siyakwamakela
// - src/main/java/com/example/Application.java
// ```java
// package com.example;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
//
// @SpringBootApplication
// public class Application {
// public static void main(String[] args) {
// SpringApplication.run(Application.class, args);
// }
// }
// ```
// ## Okuqukethwe Okudingekayo Kwamafayela Akhona
// - src/main/java/com/example/controller/MessageController.java
// ```java
// package com.example.controller;
// import com.example.service.MessageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// @Controller
// @ResponseBody
// public class MessageController {
// private final MessageService messageService;
// @Autowired
// public MessageController(MessageService messageService) {
// this.messageService = messageService;
// }
// @RequestMapping(value = "/welcome")
// public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
// return messageService.getWelcomeMessage(name);
// }
// }
// ```
// ## Okuqukethwe Okudingekayo Kwamafayela Akhona
// - src/main/java/com/example/controller/MessageController.java
// ```java
// package com.example.controller;
// import com.example.service.MessageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// @Controller
// @ResponseBody
// public class MessageController {
// private final MessageService messageService;
// @Autowired
// public MessageController(MessageService messageService) {
// this.messageService = messageService;
// }
// @RequestMapping(value = "/welcome")
// public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
// return messageService.getWelcomeMessage(name);
// }
// }
// ```
// ## Inqwaba Yobuchwepheshe
// - src/main/java/com/example/Application.java
// ```java
// package com.example;
//
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
//
// @SpringBootApplication
//