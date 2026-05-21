package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    /**
     * Generates a welcome message for the given username.
     *
     * @param username the username of the user
     * @return a welcome message in HTML format
     */
    public String getWelcomeMessage(String username) {
        return "<h1>Siyakwamukela, " + username + "!</h1>";
    }
}