package com.example.service;

import org.springframework.stereotype.Service;

/**
 * A service for generating user-related messages.
 */
@Service
public class MessageService {

    /**
     * Generates a personalized HTML welcome message for a user.
     *
     * @param username The name of the user.
     * @return An HTML string containing the welcome message.
     */
    public String getWelcomeMessage(String username) {
        // Construct the welcome message HTML.
        return "<h1>Welcome, " + username + "!</h1>";
    }
}