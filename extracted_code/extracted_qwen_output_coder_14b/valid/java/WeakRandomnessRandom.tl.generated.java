package com.example.service;

import java.security.SecureRandom;
import java.util.Random;

public class SessionService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a random and secure session ID of the specified length.
     *
     * @param length the desired length of the session ID
     * @return a randomly generated session ID
     * @throws IllegalArgumentException if the length is less than 1
     */
    public String generate(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        StringBuilder sessionId = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sessionId.append(CHARACTERS.charAt(index));
        }

        return sessionId.toString();
    }
}