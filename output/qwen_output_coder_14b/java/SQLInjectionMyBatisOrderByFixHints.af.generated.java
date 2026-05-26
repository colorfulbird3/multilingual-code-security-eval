Hier is die reggestelde Java-kode vir die `UserService`-klas:

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
     * Implement order by sorting functionality using MyBatis dynamic SQL
     * 
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // Validate input parameters to prevent SQL injection
        if (orderBy == null || orderBy.isEmpty() || sortDirection == null || sortDirection.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters for ordering");
        }
        
        // Sanitize input parameters
        String sanitizedOrderBy = sanitizeInput(orderBy);
        String sanitizedSortDirection = sanitizeInput(sortDirection);
        
        return userMapper.getUsersByOrder(sanitizedOrderBy, sanitizedSortDirection);
    }
    
    /**
     * Get all users
     * @return User list
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    
    /**
     * Sanitize input to prevent SQL injection
     * @param input Input string to sanitize
     * @return Sanitized string
     */
    private String sanitizeInput(String input) {
        // Simple sanitization to remove special characters
        return input.replaceAll("[^a-zA-Z0-9_]", "");
    }
}
]]>
        </content>
    </code>
</result>
```

Hier is die reggestelde XML-karteringslêer vir die `UserMapper`:

```xml
<result>
    <code>
        <path>
            src/main/resources/mapper/UserMapper.xml
        </path>
        <content>
            <![CDATA[
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.UserMapper">
    
    <select id="getUsersByOrder" resultType="com.example.model.User">
        SELECT * FROM users
        ORDER BY ${orderBy} ${sortDirection}
    </select>
    
    <select id="getAllUsers" resultType="com.example.model.User">
        SELECT * FROM users
    </select>
    
</mapper>
]]>
        </content>
    </code>
</result>
```

Hier is die reggestelde Java-kode vir die `UserMapper`-implementering:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/mapper/UserMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User data access interface
 */
public interface UserMapper {
    
    /**
     * Query user list by sorting field and sorting direction
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection);
    
    /**
     * Query all users
     * @return User list
     */
    List<User> getAllUsers();
}
]]>
        </content>
    </code>
</result>
```

Hier is die reggestelde Java-kode vir die `User`-entiteitsklas:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/model/User.java
        </path>
        <content>
            <![CDATA[
package com.example.model;

import java.util.Date;

public class User {
    private Long id;
    private String username;
    private String email;
    private Date createTime;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
]]>
        </content>
    </code>
</result>
```

Hier is die reggestelde Java-kode vir die `UserMapper`-implementering:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/mapper/UserMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User data access interface
 */
public interface UserMapper {
    
    /**
     * Query user list by sorting field and sorting direction
     * @param orderBy Sorting field
     * @param sortDirection Sorting direction
     * @return User list
     */
    List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection);
    
    /**
     * Query all users
     * @return User list
     */
    List<User> getAllUsers();
}
]]>
        </content>
    </code>
</result>
```

Hier is die reggestelde Java-kode vir die `User`-entiteitsklas:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/model/User.java
        </path>
        <content>
            <![CDATA[
package com.example.model;

import java.util.Date;

public class User {
    private Long id;
    private String username;
    private String email;
    private Date createTime;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
]]>
        </content>
    </code>
</result>
```