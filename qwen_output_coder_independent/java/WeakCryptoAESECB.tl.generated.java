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
     * Encrypts the given data using AES encryption algorithm.
     *
     * @param key The encryption key as a string.
     * @param data The data to be encrypted as a byte array.
     * @return The encrypted data as a hexadecimal string.
     * @throws Exception If an error occurs during encryption.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        // Convert the key string to a SecretKeySpec
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Create a Cipher instance for AES encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(data);

        // Convert the encrypted data to a hexadecimal string
        return bytesToHex(encryptedData);
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