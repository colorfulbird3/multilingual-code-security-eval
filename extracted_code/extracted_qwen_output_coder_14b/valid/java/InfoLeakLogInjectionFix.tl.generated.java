package com.example.core.service;

import com.example.core.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

            if (userProfile != null) {
                // Log the user information at INFO level for debugging and tracking
                logger.info("Processing user profile for userId: {}, username: {}, phoneNumber: {}, idCard: {}",
                        userProfile.getUserId(), userProfile.getUsername(), userProfile.getPhoneNumber(), userProfile.getIdCard());
                // Further processing logic would go here
            } else {
                logger.warn("User profile not found for userId: {}", userId);
            }
        } catch (Exception e) {
            // Catching a general Exception for demonstration.
            // In production, specific exceptions (e.g., SQLException, NetworkException) should be handled.
            logger.error("An error occurred while processing user profile for userId: {}", userId, e);
            // Re-throw or wrap the exception if further handling is required upstream
            throw new RuntimeException("Failed to process user profile for " + userId, e);
        }
    }

    /**
     * Simulates fetching a UserProfile from a database.
     * In a real scenario, this would interact with a data source.
     * For this example, it returns a hardcoded UserProfile.
     *
     * @param userId The ID of the user to fetch.
     * @return A UserProfile object, or null if not found.
     */
    private UserProfile fetchUserProfileFromDatabase(String userId) {
        // This is a mock implementation. Replace with actual data fetching logic.
        if ("1".equals(userId)) {
            return new UserProfile("1", "John Doe", "330101199001011234", "13800138000");
        } else if ("2".equals(userId)) {
            return new UserProfile("2", "Jane Smith", "330101199202025678", "13912345678");
        }
        return null; // User not found
    }
}