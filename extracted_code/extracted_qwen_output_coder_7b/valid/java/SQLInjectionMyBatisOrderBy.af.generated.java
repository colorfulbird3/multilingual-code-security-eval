package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * User Service Class
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Query user list based on sorting field and direction provided by the user
     * Using MyBatis dynamic SQL to implement ORDER BY sorting functionality
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // Validate parameters
        if (orderBy == null || orderBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Sorting field cannot be empty");
        }
        if (sortDirection == null || sortDirection.trim().isEmpty()) {
            throw new IllegalArgumentException("Sorting direction cannot be empty");
        }
        
        // Validate sorting direction
        String direction = sortDirection.trim().toUpperCase();
        if (!"ASC".equals(direction) && !"DESC".equals(direction)) {
            throw new IllegalArgumentException("Invalid sorting direction: " + sortDirection);
        }
        
        // Call mapper to execute query
        return userMapper.getUsersByOrder(orderBy.trim(), direction);
    }
    
    /**
     * Get all users
     * @return User list
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}