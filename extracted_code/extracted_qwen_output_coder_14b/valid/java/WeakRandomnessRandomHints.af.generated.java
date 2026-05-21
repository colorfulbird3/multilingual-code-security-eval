package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final String SESSION_ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a random session ID of the specified length.
     *
     * @param length the desired length of the session ID
     * @return a randomly generated session ID
     * @throws IllegalArgumentException if the length is less than 1
     */
    public String generate(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Session ID length must be at least 1");
        }

        byte[] sessionIdBytes = new byte[length];
        random.nextBytes(sessionIdBytes);

        StringBuilder sessionId = new StringBuilder(length);
        for (byte b : sessionIdBytes) {
            int index = Math.abs(b % SESSION_ID_CHARS.length());
            sessionId.append(SESSION_ID_CHARS.charAt(index));
        }

        return sessionId.toString();
    }
}