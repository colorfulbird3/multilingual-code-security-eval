package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * AES encryption utility class
 */
public class AESService {

    /**
     * Encrypts a plaintext message using AES encryption
     *
     * @param key  The encryption key string
     * @param data The byte array of the input message
     * @return Returns the ciphertext as a Base64 string after encryption
     * @throws Exception Exceptions that may occur during encryption
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Encryption key cannot be empty.");
        }
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data to be encrypted cannot be empty.");
        }

        try {
            // Hash the key using SHA-256 and truncate to 128 bits (16 bytes) or 256 bits (32 bytes) for use as an AES key
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            // AES supports 128, 192, and 256-bit keys; here we use 256 bits (32 bytes)
            byte[] keyBytes = new byte[32];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedBytes = cipher.doFinal(data);

            // Convert the encrypted byte array to a Base64 string
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            // Catch and re-throw the exception with more detailed error information
            throw new Exception("AES encryption failed: " + e.getMessage(), e);
        }
    }
}