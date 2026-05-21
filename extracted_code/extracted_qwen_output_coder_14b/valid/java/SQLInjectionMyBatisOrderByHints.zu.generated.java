package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // TODO: Implement this method
        return null;
    }

    public List<User> getAllUsers() {
        // TODO: Implement this method
        return null;
    }
}