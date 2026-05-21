package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Calculate the hash value of the provided data using SHA-256 algorithm.
     *
     * @param data The byte array containing the file content.
     * @return The hexadecimal representation of the hash value.
     * @throws IllegalArgumentException If the hashing algorithm is not supported.
     */
    public String digest(byte[] data) {
        try {
            // Create a MessageDigest instance for the SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Compute the hash value
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
            throw new IllegalArgumentException("Unsupported hashing algorithm", e);
        }
    }
}