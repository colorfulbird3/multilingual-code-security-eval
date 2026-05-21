Here's the optimized and improved version of the `HashService` class in Java:

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

/**
 * Hash service class for computing message digests of data.
 */
public class HashService {

    private static final String ALGORITHM = "SHA-256"; // Using SHA-256 instead of MD5 for better security

    /**
     * Computes the hash of the input data and returns it as a hexadecimal string.
     *
     * @param data the input byte array
     * @return the hexadecimal string representation of the hash
     * @throws RuntimeException if the hash algorithm is not supported
     */
    public String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hashBytes = digest.digest(data);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not supported: " + ALGORITHM, e);
        }
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes the byte array
     * @return the hexadecimal string
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
]]>
        </content>
    </code>
</result>
```

### Changes Made:
1. **Algorithm Change**: Changed the hashing algorithm from MD5 to SHA-256. MD5 is considered cryptographically broken and unsuitable for further use, while SHA-256 is more secure.
2. **Code Formatting**: Improved code readability by ensuring consistent formatting and adding comments for clarity.
3. **Exception Handling**: The exception handling remains the same, but using a more secure algorithm enhances overall application security.