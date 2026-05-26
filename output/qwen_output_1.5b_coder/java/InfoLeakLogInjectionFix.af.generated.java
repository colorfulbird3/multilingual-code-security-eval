.example.core.model;

public class UserProfile {
    private String userId;
    private String username;
    private String phoneNumber;
    private String idCard;

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
```

- src/main/resources/logback.xml
```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

- src/test/java/com/example/core/service/UserProfileServiceTest.java
```java
package com.example.core.service;

import com.example.core.model.UserProfile;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileServiceTest {

    @Test
    public void testProcessUserProfileWithValidInput() {
        UserProfileService service = new UserProfileService();
        String userId = "1";
        UserProfile expectedUserProfile = new UserProfile("1", "John Doe", "330101199001011234", "13800138000");

        UserProfile result = service.processUserProfile(userId);
        assertEquals(expectedUserProfile, result);
    }

    @Test
    public void testProcessUserProfileWithInvalidInput() {
        UserProfileService service = new UserProfileService();
        String userId = null;
        assertThrows(IllegalArgumentException.class, () -> service.processUserProfile(userId));
    }

    @Test
    public void testProcessUserProfileWithMissingData() {
        UserProfileService service = new UserProfileService();
        String userId = "3"; // Invalid userId
        assertNull(service.processUserProfile(userId));
    }

    @Test
    public void testProcessUserProfileWithErrorHandling() {
        UserProfileService service = new UserProfileService();
        String userId = "2";

        try {
            service.processUserProfile(userId);
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Failed to process user profile"));
            assertTrue(e.getCause() instanceof Exception); // Ensure the cause is an instance of Exception
        }
    }
}
```

## Uitvoer

Laat die `UserProfileServiceTest` klasse uitvoer, en kijk na of alle unit tests geslaag zijn. If all tests pass, then your implementation is correct.