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
```

## Uitsetformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/UserService.java` uit in die volgende formaat:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
