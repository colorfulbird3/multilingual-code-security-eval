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
     * @return randomly generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        String base64String = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);

        // Ensure the string meets the character set requirements
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = base64String.charAt(i) % CHARACTERS.length();
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