package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.util.List;

/**
 * Iklasi yesevisi yomsebenzisi
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Buza uhlu lwabasebenzisi ngokusekelwe enkambeni yokuhlunga kanye nesiqondiso sokuhlunga esinikezwe umsebenzisi
     * Sebenzisa umsebenzi wokuhlunga nge-order usebenzisa i-MyBatis dynamic SQL
     * 
     * @param orderBy Inkomba yokuhlunga
     * @param sortDirection Isiqondiso sokuhlunga
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Thola bonke abasebenzisi
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}