package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Isikole Sezinsizakalo Zomsebenzisi
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Buza uhlu lwabasebenzisi ngokusekelwe enkambeni yokuhlunga nendawo yokuhlunga enikezwe umsebenzisi
     * Kusetshenziswa i-MyBatis dynamic SQL ukusebenzisa umsebenzi wokuhlunga we-ORDER BY
     * 
     * @param