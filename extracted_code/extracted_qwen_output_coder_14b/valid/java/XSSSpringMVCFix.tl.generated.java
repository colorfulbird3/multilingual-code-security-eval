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
        // Validate input to prevent XSS attacks
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        // Construct the welcome message HTML.
        return "<h1>Welcome, " + escapeHtml(username) + "!</h1>";
    }

    /**
     * Helper method to escape HTML special characters.
     *
     * @param value The string to be escaped.
     * @return An escaped string.
     */
    private String escapeHtml(String value) {
        if (value == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}