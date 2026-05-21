```xml
<result>
    <code>
        <path>src/main/java/com/example/service/MessageService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.stereotype.Service;

/**
 * A service for generating user-related messages.
 */
@Service
public class MessageService {

    /**
     * Generates a personalized HTML welcome message for a user.
     *
     * @param username The name of the user.
     * @return An HTML string containing the welcome message.
     */
    public String getWelcomeMessage(String username) {
        // Construct the welcome message HTML.
        return "<h1>Welcome, " + escapeHtml(username) + "!</h1>";
    }

    /**
     * Escapes HTML characters in the input string.
     *
     * @param input The input string to escape.
     * @return The escaped string.
     */
    private String escapeHtml(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '&': sb.append("&amp;"); break;
                case '"': sb.append("&quot;"); break;
                case '\'': sb.append "&#x27;"); break;
                default: sb.append(c); break;
            }
        }
        return sb.toString();
    }
}
            ]]>
        </content>
    </code>
</result>
```