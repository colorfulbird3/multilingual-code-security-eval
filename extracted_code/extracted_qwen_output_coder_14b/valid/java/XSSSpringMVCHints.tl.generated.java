package com.example.service;

public class MessageService {

    public String getWelcomeMessage(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return "<h1>Welcome, " + username + "!</h1>";
    }
}