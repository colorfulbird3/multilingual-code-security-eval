package com.example.core.service;

import com.example.core.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        try {
            UserProfile userProfile = getUserProfileById(userId);
            if (userProfile != null) {
                logger.info("Processing user profile for user ID: {}", userProfile.getUserId());
                // Simulate processing logic here
            } else {
                logger.warn("User profile not found for user ID: {}", userId);
            }
        } catch (Exception e) {
            logger.error("Error processing user profile for user ID: {}", userId, e);
        }
    }

    private UserProfile getUserProfileById(String userId) {
        // Simulate fetching user profile from a database or other data source
        switch (userId) {
            case "1":
                return new UserProfile("1", "John Doe", "330101199001011234", "13800138000");
            case "2":
                return new UserProfile("2", "Jane Smith", "330101199202025678", "13912345678");
            default:
                return null;
        }
    }
}