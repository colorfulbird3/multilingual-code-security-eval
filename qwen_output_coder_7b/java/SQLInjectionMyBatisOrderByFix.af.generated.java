```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/UserService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

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
     * Query user list based on sorting field and sorting direction provided by the user
     * Uses MyBatis dynamic SQL to implement order by sorting functionality
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return List of users
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Get all users
     * @return List of users
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