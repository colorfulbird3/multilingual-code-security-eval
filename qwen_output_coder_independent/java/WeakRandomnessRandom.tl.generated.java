```xml
<result>
    <code>
        <path>src/main/java/com/example/service/SessionService.java</path>
        <content><![CDATA[
package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionService {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generates a secure session ID with the specified length.
     *
     * @param length The length of the session ID to generate.
     * @return A secure session ID as a String.
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);

        StringBuilder sb = new StringBuilder();
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