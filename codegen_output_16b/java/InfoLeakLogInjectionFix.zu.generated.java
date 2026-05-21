Number(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
```

## Nyefayo ukusetshenziswa

- src/main/java/com/example/core/service/UserProfileService.java
```java
package com.example.core.service;

import com.example.core.model.UserProfile;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    /**
     * Processes a user profile based on the given userId.
     * This method simulates fetching user information and logs it for debugging purposes.
     *
     * @param userId The ID of the user whose profile is to be processed.
     */
    public void processUserProfile(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            logger.warn("Attempted to process user profile with a null or empty userId.");
            throw new IllegalArgumentException("User ID cannot be null or empty.");
        }

        try {
            // Simulate fetching user profile information
            // In a real application, this would involve database lookups or API calls.
            UserProfile userProfile = fetchUserProfileFromDatabase(userId);

            if (userProfile!= null) {
                // Log the user information at INFO level for debugging and tracking
                logger.info("Processing user profile for userId: {}, username: {}, phoneNumber: {}, idCard: {}",
                        userProfile.getUserId(), userProfile.getUsername(), userProfile.getPhoneNumber(),userProfile.getIdCard());
                // Further processing logic would go here
            } else {
                logger.warn("User profile not found for userId: {}", userId);
            }