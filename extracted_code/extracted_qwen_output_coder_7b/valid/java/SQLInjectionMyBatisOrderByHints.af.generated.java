```java
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import java.util.List;

public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        if (orderBy == null || orderBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Sort field cannot be empty");
        }
        if (sortDirection == null || sortDirection.trim().isEmpty()) {
            throw new IllegalArgumentException("Sort direction cannot be empty");
        }

        String direction = sortDirection.trim().toUpperCase();
        if (!"ASC".equals(direction) && !"DESC".equals(direction)) {
            throw new IllegalArgumentException("Invalid sort direction: " + sortDirection + ". Only ASC or DESC is supported");
        }

        String validOrderBy = validateOrderByField(orderBy.trim());

        return userMapper.getUsersByOrder(validOrderBy, direction);
    }

    private String validateOrderByField(String orderBy) {
        String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};

        for (String field : allowedFields) {
            if (field.equalsIgnoreCase(orderBy)) {
                return field;
            }
        }

        throw new IllegalArgumentException("Invalid sort field: " + orderBy + ". Allowed fields are: id, username, email, phone, address, create_time, update_time, status");
    }
}
```