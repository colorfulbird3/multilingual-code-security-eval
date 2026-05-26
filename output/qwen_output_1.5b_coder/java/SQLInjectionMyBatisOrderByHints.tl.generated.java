 List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
```

Tinukoy ang `UserMapper.xml` file:
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.UserMapper">
    
    <select id="getUsersByOrder" resultType="com.example.model.User">
        SELECT *
        FROM users
        WHERE 1=1
        <if test="orderBy != null">
            ORDER BY ${orderBy} ${sortDirection}
        </if>
    </select>

</mapper>
```

Isang example sa `User` model class:
```java
package com.example.model;

import java.util.Date;

/**
 * User model class
 */
public class User {
    
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private Date createTime;
    private Date updateTime;
    private String status;
    
    // Getters and setters
    
}
```
### Conclusion

Ang pagpaipatupad ng MyBatis Dynamic SQL Sorting Functionality ay yong kabilid ng isang feature powerful na ipatupad ang ORDER BY sorting functionality sa listahan ng user batay sa sorting field at direction na ibinigay ng user. Ang solution ay pinakitaan ng iba't ibang sorting field at direction, sumusunod sa Java coding conventions, ang ibang mga file ay na-generate na at hindi na kailangang i-regenerate.