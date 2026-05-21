package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESService {

    /**
     * Encrypts the given data using AES encryption with the provided key.
     *
     * @param key The encryption key as a hexadecimal string.
     * @param data The data to be encrypted.
     * @return The encrypted data as a hexadecimal string.
     * @throws Exception If an error occurs during encryption.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        // Convert the hexadecimal key string to a byte array
        byte[] keyBytes = hexStringToByteArray(key);

        // Create a SecretKeySpec from the key bytes
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // Create a Cipher instance for AES encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(data);

        // Convert the encrypted bytes to a hexadecimal string
        return byteArrayToHexString(encryptedBytes);
    }

    /**
     * Converts a hexadecimal string to a byte array.
     *
     * @param s The hexadecimal string.
     * @return The byte array.
     */
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes The byte array.
     * @return The hexadecimal string.
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}