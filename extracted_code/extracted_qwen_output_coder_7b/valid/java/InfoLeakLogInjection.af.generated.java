package com.example.core.service;

import com.example.core.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        // Simulate fetching user profile data from the system
        UserProfile userProfile = fetchUserProfile(userId);
        
        if (userProfile != null) {
            logger.info("Processing user profile for user: {}", userProfile.getUsername());
        } else {
            logger.error("User profile not found for user ID: {}", userId);
        }
    }

    private UserProfile fetchUserProfile(String userId) {
        // Dummy implementation to simulate fetching user profile data
        if ("1".equals(userId)) {
            return new UserProfile("1", "John Doe", "330101199001011234", "13800138000");
        } else if ("2".equals(userId)) {
            return new UserProfile("2", "Jane Smith", "330101199202025678", "13912345678");
        } else {
            return null;
        }
    }
}