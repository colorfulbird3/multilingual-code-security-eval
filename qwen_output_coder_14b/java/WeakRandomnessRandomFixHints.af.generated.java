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
import java.util.Base64;

public class SessionService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * Generates a secure session ID of the specified length
     * @param length the length of the session ID, must be greater than 0
     * @return securely generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);

        // Encode bytes to Base64 to ensure it uses only the defined character set
        String encodedString = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

        // Ensure the length of the session ID matches the requested length
        if (encodedString.length() > length) {
            return encodedString.substring(0, length);
        } else {
            StringBuilder sb = new StringBuilder(encodedString);
            while (sb.length() < length) {
                sb.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
            }
            return sb.toString();
        }
    }
}
]]>
        </content>
    </code>
</result>
```