package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.util.List;

/**
 * User service class
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Query user list based on sorting field and sorting direction provided by the user
     * Implement order by sorting functionality using MyBatis dynamic SQL
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // Validate input parameters to prevent SQL injection
        if (orderBy == null || orderBy.isEmpty() || sortDirection == null || sortDirection.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters for ordering");
        }
        
        // Sanitize input parameters
        String sanitizedOrderBy = sanitizeInput(orderBy);
        String sanitizedSortDirection = sanitizeInput(sortDirection);
        
        return userMapper.getUsersByOrder(sanitizedOrderBy, sanitizedSortDirection);
    }
    
    /**
     * Get all users
     * @return User list
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    
    /**
     * Sanitize input to prevent SQL injection
     * @param input Input string to sanitize
     * @return Sanitized string
     */
    private String sanitizeInput(String input) {
        // Simple sanitization to remove special characters
        return input.replaceAll("[^a-zA-Z0-9_]", "");
    }
}