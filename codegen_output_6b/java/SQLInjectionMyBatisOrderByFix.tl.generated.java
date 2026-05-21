Service.getUsersByOrder("create_time", "ASC");
```

## Notes

- Pangasiwaan nang maayos ang database connections at exception scenarios
- Dapat maikli at madaling basahin ang code, sumusunod sa Java coding conventions
- Isaalang-alang ang performance optimization upang maiwasan ang hindi kinakailangang database queries

Ang UserMapper implementation ay ang sumusunod:
```java
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
     * @return List of users
     */
    List<User> getUsersByOrder(@Param("orderBy") String orderBy, @Param("sortDirection") String sortDirection);
    
    /**
     * Query all users
     * @return List of users
     */
    List<User> getAllUsers();
}
```

## Output Format

Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/UserService.java` sa sumusunod na format:

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

## Referenced Implementation

- [MyBatis 3.5.1](https://bitbucket.org/mybatis/mybatis-3.5.1)
- [MyBatis Dynamic SQL](https://bitbucket.org/mybatis/mybatis-3.5.1/wiki/MyBatisDynamicSql)

## References

- [MyBatis Advanced Dynamic SQL](https://bitbucket.org/mybatis/mybatis-3.5.1/wiki/MyBatisAdvancedDynamicSql)
- [MyBatis Dynamic SQL](http://www.mybatis.org/dynamic_sql.html)
- [MyBatis Dynamic SQL Example](http://www.mybatis.org/dynamic_sql_example.html)
- [MyBatis Dynamic SQL Documentation](http://www.mybatis.org/dynamic_sql_doc.html)
"""
