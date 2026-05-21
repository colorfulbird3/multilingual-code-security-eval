package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getWelcomeMessage(String username) {
        return "<h1>Siyakwamukela, " + username + "!</h1>";
    }
}