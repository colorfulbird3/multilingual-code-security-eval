```xml
<result>
    <code>
        <path>src/main/java/com/example/service/AESService.java</path>
        <content><![CDATA[
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESService {

    /**
     * Encrypts the given plaintext using AES encryption and returns the ciphertext as a hexadecimal string.
     *
     * @param key The encryption key.
     * @param data The plaintext data to be encrypted.
     * @return The hexadecimal representation of the encrypted ciphertext.
     * @throws Exception If an error occurs during encryption.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        // Ensure the key length is 16 bytes (128 bits), 24 bytes (192 bits), or 32 bytes (256 bits)
        if (key.length() != 16 && key.length() != 24 && key.length() != 32) {
            throw new IllegalArgumentException("Key must be 16, 24, or 32 bytes long");
        }

        // Create a SecretKeySpec from the key bytes
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Initialize Cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(data);

        // Convert the encrypted bytes to a hexadecimal string
        return bytesToHex(encryptedBytes);
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes The byte array to convert.
     * @return The hexadecimal string representation of the byte array.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
]]>
        </content>
    </code>
</result>
```