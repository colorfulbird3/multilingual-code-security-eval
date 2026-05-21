package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.util.List;

/**
 * User service class
 */
public class UserService {
    
    private final UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Query user list based on sorting field and sorting direction provided by the user
     * Uses MyBatis dynamic SQL to implement order by sorting functionality
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return List of users
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // Validate input parameters to prevent SQL injection
        if (orderBy == null || sortDirection == null || !("ASC".equalsIgnoreCase(sortDirection) || "DESC".equalsIgnoreCase(sortDirection))) {
            throw new IllegalArgumentException("Invalid sorting parameters");
        }
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Get all users
     * @return List of users
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}