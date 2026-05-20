package com.example.service;

/**
 * Service class to handle message generation.
 */
public class MessageService {

    /**
     * Generates a welcome message for the given username.
     *
     * @param username The username of the user.
     * @return A welcome message as an HTML string.
     */
    public String getWelcomeMessage(String username) {
        return "<h1>Welcome, " + username + "!</h1>";
    }
}