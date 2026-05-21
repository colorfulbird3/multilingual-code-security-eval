package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return Base64.getUrlEncoder().encodeToString(sb.toString().getBytes());
    }

    public static void main(String[] args) {
        SessionService service = new SessionService();
        String sessionId = service.generate(32);
        System.out.println("Generated Session ID: " + sessionId);
    }
}