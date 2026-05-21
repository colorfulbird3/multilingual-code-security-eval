```java
package com.example.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        if (userId == null || userId.isEmpty()) {
            logger.warn("User ID is null or empty");
            throw new IllegalArgumentException("User ID must not be null or empty");
        }

        try {
            UserProfile userProfile = fetchUserProfileFromDatabase(userId);
            if (userProfile != null) {
                logger.info("User profile found: {}", userProfile);
            } else {
                logger.warn("User profile not found for userId: {}", userId);
            }
        } catch (Exception e) {
            logger.error("Error processing user profile for userId: {}", userId, e);
            throw new RuntimeException("Failed to process user profile", e);
        }
    }

    private UserProfile fetchUserProfileFromDatabase(String userId) {
        // Simulate database fetch
        if ("1".equals(userId)) {
            return new UserProfile("1", "Alice", "1234567890", "ID001");
        } else if ("2".equals(userId)) {
            return new UserProfile("2", "Bob", "0987654321", "ID002");
        }
        return null;
    }
}
```