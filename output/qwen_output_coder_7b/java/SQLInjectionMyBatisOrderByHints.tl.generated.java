```xml
<result>
    <code>
        <path>src/main/java/com/example/service/UserService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * User service class
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Query user list based on sorting field and direction provided by the user
     * Using MyBatis dynamic SQL to implement ORDER BY sorting functionality
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Get all users
     * @return User list
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
} 
            ]]>
        </content>
    </code>
</result>
```