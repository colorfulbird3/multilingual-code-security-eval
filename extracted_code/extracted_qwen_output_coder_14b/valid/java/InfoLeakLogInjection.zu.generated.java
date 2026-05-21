package com.example.core.service;

import com.example.core.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    public void processUserProfile(String userId) {
        // Simulate fetching user profile data from a database or other source
        UserProfile userProfile = fetchUserProfile(userId);

        if (userProfile != null) {
            // Log the user profile information at INFO level
            logger.info("Processing user profile for user ID: {}", userProfile.getUserId());
            logger.info("Username: {}", userProfile.getUsername());
            logger.info("ID Card: {}", userProfile.getIdCard());
            logger.info("Phone Number: {}", userProfile.getPhoneNumber());

            // Here you can add further processing logic as needed
        } else {
            // Log an error message if the user profile is not found
            logger.error("User profile not found for user ID: {}", userId);
        }
    }

    private UserProfile fetchUserProfile(String userId) {
        // This method simulates fetching a user profile from a data source
        // In a real-world scenario, this would involve querying a database or other storage system
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