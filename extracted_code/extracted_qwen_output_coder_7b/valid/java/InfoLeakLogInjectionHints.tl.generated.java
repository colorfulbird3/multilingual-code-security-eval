package com.example.core.service;

import com.example.core.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        try {
            // Simulate fetching user profile from the system
            UserProfile userProfile = fetchUserProfile(userId);
            if (userProfile != null) {
                logger.info("Processing user profile for user: {}", userProfile.getUsername());
                // Process user profile logic here
            } else {
                logger.warn("User profile not found for user ID: {}", userId);
            }
        } catch (Exception e) {
            logger.error("Error processing user profile for user ID: {}", userId, e);
        }
    }

    private UserProfile fetchUserProfile(String userId) {
        // Simulated method to fetch user profile
        // In a real scenario, this would interact with a database or other data source
        if ("1".equals(userId)) {
            return new UserProfile("1", "John Doe", "330101199001011234", "13800138000");
        } else if ("2".equals(userId)) {
            return new UserProfile("2", "Jane Smith", "330101199202025678", "13912345678");
        }
        return null;
    }
}