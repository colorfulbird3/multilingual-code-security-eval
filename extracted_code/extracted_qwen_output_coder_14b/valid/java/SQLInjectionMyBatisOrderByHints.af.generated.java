package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        if (orderBy == null || orderBy.isEmpty() || sortDirection == null || sortDirection.isEmpty()) {
            throw new IllegalArgumentException("Order by and sort direction must not be null or empty");
        }

        if (!sortDirection.equalsIgnoreCase("ASC") && !sortDirection.equalsIgnoreCase("DESC")) {
            throw new IllegalArgumentException("Sort direction must be ASC or DESC");
        }

        validateOrderByField(orderBy);

        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }

    private void validateOrderByField(String orderBy) {
        List<String> allowedFields = List.of("id", "username", "email", "created_at");
        if (!allowedFields.contains(orderBy)) {
            throw new IllegalArgumentException("Invalid order by field: " + orderBy);
        }
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}