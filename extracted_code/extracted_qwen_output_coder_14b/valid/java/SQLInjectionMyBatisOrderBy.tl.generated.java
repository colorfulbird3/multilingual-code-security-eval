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

    /**
     * Retrieves a list of users sorted by the specified field and direction.
     *
     * @param orderBy the field to sort by
     * @param sortDirection the direction of sorting (ASC or DESC)
     * @return a list of users sorted accordingly
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        //TODO: implement
        return null;
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        //TODO: implement
        return null;
    }
}