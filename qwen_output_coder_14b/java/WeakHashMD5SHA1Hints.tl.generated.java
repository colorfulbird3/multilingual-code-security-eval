```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/HashService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Computes the hash value of the given data using SHA-256 algorithm.
     *
     * @param data the byte array containing the file content
     * @return the hexadecimal representation of the hash value
     * @throws RuntimeException if the SHA-256 algorithm is not available
     */
    public String digest(byte[] data) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Compute the hash value
            byte[] hashBytes = md.digest(data);
            
            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```