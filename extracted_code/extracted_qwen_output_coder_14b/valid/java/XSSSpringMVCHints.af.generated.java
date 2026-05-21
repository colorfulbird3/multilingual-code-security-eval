package com.example.service;

public class MessageService {

    /**
     * Generates a welcome message with the provided username.
     *
     * @param username the username of the user
     * @return an HTML-formatted welcome message
     */
    public String getWelcomeMessage(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return "<h1>Welkom, " + username + "!</h1>";
    }
}