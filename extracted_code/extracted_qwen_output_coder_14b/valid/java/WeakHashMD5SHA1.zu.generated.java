package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    public String digest(byte[] data) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Compute the hash
            byte[] hashBytes = md.digest(data);
            
            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        HashService hashService = new HashService();
        
        // Example usage
        String input = "Hello, World!";
        byte[] data = input.getBytes();
        
        String hash = hashService.digest(data);
        System.out.println("Hash: " + hash);
    }
}