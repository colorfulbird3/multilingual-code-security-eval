Here's the Java implementation for the HashService class based on the requirements provided:

```java
package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {
    public String digest(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(data);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithm not found", e);
        }
    }
}
```

This implementation uses Java's built-in MessageDigest class to compute the SHA-256 hash of the input byte array. The resulting byte array is then converted to a hexadecimal string representation. This meets all the requirements specified, including handling potential exceptions and ensuring the output is in lowercase hexadecimal format.