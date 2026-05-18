```xml
<result>
    <code>
        <path>src/main/java/com/example/service/AESService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * AES encryption utility class
 */
public class AESService {

    /**
     * Encrypts a plaintext message using AES encryption
     *
     * @param key  The encryption key string
     * @param data The byte array of the input message
     * @return Returns the ciphertext as a hexadecimal string after encryption
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
            // Hash the key using SHA-256 and truncate to 256 bits (32 bytes) for use as an AES key
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            byte[] keyBytes = Arrays.copyOf(digest.digest(), 32);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedBytes = cipher.doFinal(data);

            // Convert the encrypted byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("SHA-256 algorithm not found: " + e.getMessage(), e);
        } catch (Exception e) {
            // Catch and re-throw the exception with more detailed error information
            throw new Exception("AES encryption failed: " + e.getMessage(), e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```