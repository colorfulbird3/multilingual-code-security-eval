package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final String SESSION_ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Session ID length must be greater than zero");
        }

        StringBuilder sessionId = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(SESSION_ID_CHARS.length());
            sessionId.append(SESSION_ID_CHARS.charAt(index));
        }

        // Encode to Base64 to ensure it's URL safe and can be used in cookies or URLs
        return Base64.getUrlEncoder().withoutPadding().encodeToString(sessionId.toString().getBytes());
    }
}