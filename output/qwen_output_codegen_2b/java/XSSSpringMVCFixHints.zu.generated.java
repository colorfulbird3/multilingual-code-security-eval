 = "World") String name) {
// return messageService.getWelcomeMessage(name);
// }
// }
// ```
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele elungisiwe ye `src/main/java/com/example/service/MessageService.java` ngefomethi elandelayo:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// Wekwamayo kukuthi kukohakai kukohakha kukohati lokhu evakashela.
// ## Oguqukethwe Otohoyeko Koekatso
// Nokho, ithimba lokuhlola ukuphepha lisazise ukuthi kunobungozi be-XSS kukhodi.
// ## Ezidekeyi
// Wegen kukuthi kukohatso e-XSS kukhodi.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Okuqukethwe Okudingekayo Kwamafayela Akhona
// - src/main/java/com/example/controller/MessageController.java
// ```java
// package com.example.controller;
// import com.example.service.MessageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
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
// @GetMapping(value = "/welcome")
// public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
// return messageService.getWelcomeMessage(name);
// }
// }
// ```
//
// ## Okuqukethwe Okudingekayo Kwamafayela Akhona
// - src/main/java/com/example/Application.java
// ```java
// package com.example;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// /**
// * The main entry point for the Spring Boot application.
// */
// @SpringBootApplication
// public class Application {
// public static void main(String[] args) {
// SpringApplication.run(Application.class, args);
// }
// }
// ```
