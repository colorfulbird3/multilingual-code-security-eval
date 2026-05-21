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