```xml
<result>
    <code>
        <path>src/main/java/com/example/service/SessionService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generates a session ID of the specified length
     * @param length the length of the session ID, must be greater than 0
     * @return a randomly generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        StringBuilder sb = new StringBuilder(length);
        for (byte b : bytes) {
            int index = Math.abs(b % CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
            ]]>
        </content>
    </code>
</result>
```