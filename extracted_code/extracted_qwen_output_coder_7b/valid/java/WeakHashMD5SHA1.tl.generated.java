package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Calculates the message digest (hash value) of the given byte array.
     *
     * @param data the byte array representing the file content
     * @return the hexadecimal string representation of the hash value
     * @throws NoSuchAlgorithmException if the specified algorithm is not supported
     */
    public String digest(byte[] data) throws NoSuchAlgorithmException {
        // Specify the hashing algorithm to use
        String algorithm = "SHA-256";
        MessageDigest md = MessageDigest.getInstance(algorithm);
        
        // Update the digest using the specified array of bytes
        md.update(data);
        
        // Complete the hash computation
        byte[] digestBytes = md.digest();
        
        // Convert the byte array into a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : digestBytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        
        return hexString.toString();
    }
}