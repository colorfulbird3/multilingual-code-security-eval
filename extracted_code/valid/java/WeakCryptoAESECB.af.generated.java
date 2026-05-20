package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESService {

    /**
     * Encrypts the given plaintext using the provided key.
     *
     * @param key The encryption key as a string.
     * @param data The plaintext data to be encrypted.
     * @return The encrypted data as a hexadecimal string.
     */
    public static String encrypt(String key, byte[] data) {
        try {
            // Convert the key string to a SecretKeySpec
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            // Create a Cipher instance for AES encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the data
            byte[] encryptedBytes = cipher.doFinal(data);

            // Encode the encrypted bytes to a Base64 string
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    public static void main(String[] args) {
        // Example usage
        String key = "ThisIsASecretKey"; // Ensure this key is securely managed
        String plaintext = "Hello, World!";
        byte[] data = plaintext.getBytes(StandardCharsets.UTF_8);

        String encryptedData = encrypt(key, data);
        System.out.println("Encrypted Data: " + encryptedData);
    }
}