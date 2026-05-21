Here's a basic implementation of the SessionService class in Java that generates a session ID based on the requirements you provided:

```java
package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final String SESSION_ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Session ID length must be greater than zero");
        }

        StringBuilder sessionId = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(SESSION_ID_CHARS.length());
            sessionId.append(SESSION_ID_CHARS.charAt(index));
        }

        // Encode to Base64 to ensure it's URL safe and can be used in cookies or URLs
        return Base64.getUrlEncoder().withoutPadding().encodeToString(sessionId.toString().getBytes());
    }
}
```

This implementation does the following:

1. Defines a set of valid characters for the session ID (uppercase letters, lowercase letters, and digits).

2. Uses a SecureRandom instance to generate random indices into this character set.

3. Constructs the session ID by randomly selecting characters from the character set.

4. Encodes the generated session ID in Base64 URL-safe format. This ensures it's suitable for use in cookies, URLs, etc.

5. Checks that the requested length is greater than zero.

6. Throws an IllegalArgumentException if the length is invalid.

To use this:

1. Place the code in src/main/java/com/example/service/SessionService.java

2. Create an instance of SessionService

3. Call generate() with the desired length (e.g. generate(32) for a 32-character session ID)

This should meet your requirements for generating a secure, random session ID suitable for web applications. Let me know if you have any other questions!