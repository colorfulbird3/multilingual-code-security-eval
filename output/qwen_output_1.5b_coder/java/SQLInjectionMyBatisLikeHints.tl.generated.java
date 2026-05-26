="username" value="sa"/>
                <property name="password" value=""/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/example/mapper/ProductMapper.xml"/>
    </mappers>
</configuration>
```

- src/main/java/com/example/mapper/ProductMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.mapper.ProductMapper">
    <!-- Fuzzy search for products -->
    <select id="searchByName" resultType="com.example.model.Product">
        SELECT * FROM products WHERE LOWER(name) LIKE CONCAT('%', LOWER(#{name}), '%')
    </select>
</mapper>
```

## Proposed Solution

Implement the `searchByName` method in the `ProductMapper` interface using MyBatis's fuzzy query feature.

## Explanation of the Proposed Solution

The proposed solution involves using MyBatis's fuzzy query feature, which allows us to perform queries based on partial matches. In this case, we use the `LIKE` operator with wildcards (`%`) to match any string that contains the specified pattern. By converting both the input `name` and the database column `name` to lowercase before performing the comparison, we ensure that the search is case-insensitive.

Here's an example of how you can implement the `searchByName` method:

```java
public List<Product> searchByName(String name) {
    // Use the like operator with wildcards to match any string containing the specified pattern
    return sqlSession.selectList("com.example.mapper.ProductMapper.searchByName", name);
}
```

This implementation ensures that the search is case-insensitive and will return all products whose names contain the given substring, regardless of case.

## Conclusion

By implementing the `searchByName` method in the `ProductMapper` interface using MyBatis's fuzzy query feature, we can efficiently perform searches for products by their names. This approach provides a robust solution to the problem at hand while maintaining efficiency and scalability.