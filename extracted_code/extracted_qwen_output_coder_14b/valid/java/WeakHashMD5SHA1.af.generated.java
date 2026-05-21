package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Calculates the hash value of the given data using the SHA-256 algorithm.
     *
     * @param data The byte array containing the data to be hashed.
     * @return The hexadecimal string representation of the hash value.
     * @throws IllegalArgumentException if the SHA-256 algorithm is not available.
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
            // If the SHA-256 algorithm is not available, throw an IllegalArgumentException
            throw new IllegalArgumentException("SHA-256 algorithm not found", e);
        }
    }
}