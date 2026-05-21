package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import java.util.List;

public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * Retrieves a list of users sorted based on the provided order and sort direction.
     * This method uses MyBatis dynamic SQL to construct the ORDER BY clause.
     *
     * @param orderBy       The column name by which the users should be ordered.
     * @param sortDirection The direction of the sort (e.g., "ASC" for ascending, "DESC" for descending).
     * @return A list of User objects sorted according to the specified criteria.
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return A list of all User objects.
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}