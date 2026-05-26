;
// import com.example.mapper.UserMapperXML;
// import com.example.model.User;
// import java.util.List;
// import org.apache.commons.lang3.StringUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import java.util.ArrayList;
// public class UserService {
// // Use MyBatis instead of MyBatisXML
// private UserMapper mapper;
// private static Logger log = LoggerFactory.getLogger(UserService.class);
// // Sort by username in ascending order
// public List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection) {
// // Order by username
// if (StringUtils.isNotEmpty(orderBy)) {
// mapper.getUsersByOrder(orderBy, sortDirection);
// }
// else {
// log.warn("You have to provide the orderBy argument");
// }
// return mapper.getAllUsers();
// }
// // Sort by username in ascending order
// public List<User> getUsersByOrder(String orderBy, String sortDirection) {
// return getUsersByOrder(orderBy, sortDirection);
// }
//
// }
// ```
package com.example.service;

import com.example.mapper.UserMapperXML;
import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Mapper("UserMapperXML")
public class UserServiceXML extends UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceXML.class);

    @Select({
            "SELECT id, username, email, phone, address, create_time, update_time, status, firstname, lastname",
            "FROM user ORDER BY username"
    })
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection) {
        return getUsersByOrder(orderBy, sortDirection);
    }

    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return null;
    }
}