package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Bereken die SHA-256 hash-waarde van die gegee byte[] data.
     *
     * @param data die byte[] data om te hash
     * @return die heksadesimale string van die hash-waarde
     * @throws NoSuchAlgorithmException asseblief wanneer die SHA-256 algoritme nie beskikbaar is nie
     */
    public String digest(byte[] data) throws NoSuchAlgorithmException {
        // Maak 'n MessageDigest instance vir die SHA-256 algoritme
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Bereken die hash-waarde van die data
        byte[] hashBytes = md.digest(data);

        // Konverteer die byte[] hash-waarde na 'n heksadesimale string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}