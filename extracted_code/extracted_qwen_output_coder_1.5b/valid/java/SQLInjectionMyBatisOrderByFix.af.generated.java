package com.example.service;

import com.example.mapper.UserMapper;
import org.example.model.User;
import org.util.ArrayList;

public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}