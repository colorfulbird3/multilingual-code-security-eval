package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash service class for computing message digests of data.
 */
public class HashService {

    private static final String ALGORITHM = "SHA-256"; // Updated to a stronger algorithm

    /**
     * Computes the hash of the input data and returns it as a hexadecimal string.
     *
     * @param data the input byte array
     * @return the hexadecimal string representation of the hash
     * @throws RuntimeException if the hash algorithm is not supported
     */
    public String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hashBytes = digest.digest(data);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not supported: " + ALGORITHM, e);
        }
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes the byte array
     * @return the hexadecimal string
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}