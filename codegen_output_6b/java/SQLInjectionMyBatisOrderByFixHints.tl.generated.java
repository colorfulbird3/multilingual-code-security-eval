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
 * Klase ng serbisyo ng gumagamit
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Kunin ang listahan ng mga gumagamit batay sa field ng pag-uuri at direksyon ng pag-uuri na ibinigay ng gumagamit
     * Ipatupad ang order by sorting functionality gamit ang MyBatis dynamic SQL
     * 
     * @param orderBy Field ng pag-uuri
     * @param sortDirection Direksyon ng pag-uuri
     * @return Listahan ng mga gumagamit
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return userMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    /**
     * Kunin ang lahat ng mga gumagamit
     * @return Listahan ng mga gumagamit
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