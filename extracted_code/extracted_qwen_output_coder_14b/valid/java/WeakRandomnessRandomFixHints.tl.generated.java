package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a session ID of the specified length
     * @param length the length of the session ID, must be greater than 0
     * @return randomly generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}