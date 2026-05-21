package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash-diensklas vir die berekening van boodskap-afdrukke van data.
 */
public class HashService {

    private static final String ALGORITHM = "SHA-256";

    /**
     * Bereken die hash van die invoerdata en gee dit terug as 'n heksadesimale string.
     *
     * @param data invoer greepskikking
     * @return heksadesimale stringvoorstelling van die hash
     * @throws RuntimeException as die hash-algoritme nie ondersteun word nie
     */
    public String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hashBytes = digest.digest(data);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash-algoritme nie ondersteun nie: " + ALGORITHM, e);
        }
    }

    /**
     * Skakel 'n greepskikking om na 'n heksadesimale string.
     *
     * @param bytes greepskikking
     * @return heksadesimale string
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}