package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESService {

    /**
     * Encrypts the given data using AES with the provided key.
     *
     * @param key The encryption key as a hexadecimal string.
     * @param data The plaintext data to be encrypted.
     * @return The encrypted data as a hexadecimal string.
     * @throws Exception If an error occurs during encryption.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        // Convert the hexadecimal key string to a byte array
        byte[] keyBytes = hexStringToByteArray(key);
        
        // Ensure the key length is 16 bytes (128 bits)
        if (keyBytes.length != 16) {
            throw new IllegalArgumentException("Key must be 16 bytes long.");
        }

        // Create a SecretKeySpec object from the key bytes
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Initialize the Cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(data);

        // Convert the encrypted bytes to a hexadecimal string
        return bytesToHex(encryptedBytes);
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
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Example usage
            String key = "0123456789abcdef"; // 16-byte key
            String plaintext = "Hello, World!";
            byte[] data = plaintext.getBytes();

            String encryptedText = encrypt(key, data);
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}