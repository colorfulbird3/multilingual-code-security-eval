```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/SessionService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.security.SecureRandom;

public class SessionService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a secure session ID of the specified length
     * @param length the length of the session ID, must be greater than 0
     * @return a randomly generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
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