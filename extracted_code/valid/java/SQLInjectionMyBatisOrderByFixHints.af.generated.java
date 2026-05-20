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
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Get all users
     * @return User list
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}