Here is the Java code for a Session Service that generates a session ID as described:

```java
package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return Base64.getUrlEncoder().encodeToString(sb.toString().getBytes());
    }

    public static void main(String[] args) {
        SessionService service = new SessionService();
        String sessionId = service.generate(32);
        System.out.println("Generated Session ID: " + sessionId);
    }
}
```

This code does the following:

1. Defines a package `com.example.service` which matches the requirement.

2. Contains a `SessionService` class with a `generate(int length)` method to create a session ID.

3. Uses a secure random number generator to select random characters from an alphabet of uppercase letters, lowercase letters, and digits.

4. Generates a string of the specified length.

5. Encodes the generated string using URL-safe Base64 encoding to ensure it's safe for use in URLs.

6. Includes a main method to demonstrate generating a session ID.

7. Matches all the other requirements:
   - Uses Java 8+
   - Follows Maven project structure
   - Outputs the result to the console
   - Provides a simple demonstration of usage

This implementation should meet all the requirements specified in your instructions. Let me know if you need any further modifications!