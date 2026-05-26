package com.example.service;
import com.example.mapper.UserMapper;
import com.example.model.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
* Klase ng Serbisyo ng User
*/
public class UserService {
private UserMapper userMapper;
public UserService(UserMapper userMapper) {
this.userMapper = userMapper;
}
/**
* Mag-query ng listahan ng user batay sa sorting field at direksyon na ibinigay ng user
* Gamit ang MyBatis dynamic SQL para ipatupad ang ORDER BY sorting functionality
*
* @param orderBy Sorting field
* @param sortDirection Direksyon ng pag-sort
* @return Listahan ng user
*/
public List<User> getUsersByOrder(String orderBy, String sortDirection) {
//TODO
}
/**
* Kunin ang lahat ng user
* @return Listahan ng user
*/
public List<User> getAllUsers() {
// TODO
}
}