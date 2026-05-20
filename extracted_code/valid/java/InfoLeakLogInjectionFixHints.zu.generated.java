```java
package com.example.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        try {
            if (userId == null || userId.isEmpty()) {
                logger.warn("Invalid userId: {}", userId);
                return;
            }

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
        if ("123".equals(userId)) {
            return new UserProfile("123", "john_doe", "123-456-7890", "ID123456");
        }
        return null;
    }

    public static class UserProfile {
        private String userId;
        private String username;
        private String phoneNumber;
        private String idCard;

        public UserProfile(String userId, String username, String phoneNumber, String idCard) {
            this.userId = userId;
            this.username = username;
            this.phoneNumber = phoneNumber;
            this.idCard = idCard;
        }

        @Override
        public String toString() {
            return "UserProfile{" +
                    "userId='" + userId + '\'' +
                    ", username='" + username + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", idCard='" + idCard + '\'' +
                    '}';
        }
    }
}
```