package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final String SESSION_ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a random and secure session ID of the specified length.
     *
     * @param length The desired length of the session ID.
     * @return A randomly generated session ID.
     * @throws IllegalArgumentException if the length is less than or equal to zero.
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        byte[] sessionIdBytes = new byte[length];
        random.nextBytes(sessionIdBytes);

        // Encode the bytes to a Base64 string to ensure it uses only alphanumeric characters
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(sessionIdBytes);

        // Trim the Base64 string to the desired length
        return sessionId.substring(0, length);
    }
}