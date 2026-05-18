```xml
<result>
    <code>
        <path>src/main/java/com/example/service/MessageService.java</path>
        <content>
            <![CDATA[
package com.example.service;

/**
 * Service class to handle message operations.
 */
public class MessageService {

    /**
     * Generates a welcome message for the given username.
     *
     * @param username The username of the user.
     * @return A welcome message in HTML format.
     */
    public String getWelcomeMessage(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return "<h1>Welcome, " + username + "!</h1>";
    }
}
            ]]>
        </content>
    </code>
</result>
```