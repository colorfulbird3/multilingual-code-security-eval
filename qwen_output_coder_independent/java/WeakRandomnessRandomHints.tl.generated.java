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
     * Generates a random session ID of the specified length.
     *
     * @param length The length of the session ID to generate.
     * @return A randomly generated session ID.
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);

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