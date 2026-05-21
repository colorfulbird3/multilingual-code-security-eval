package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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
        // Escape the username to prevent XSS attack
        String safeUsername = HtmlUtils.htmlEscape(username);
        // Construct the welcome message HTML.
        return "<h1>Welcome, " + safeUsername + "!</h1>";
    }
}