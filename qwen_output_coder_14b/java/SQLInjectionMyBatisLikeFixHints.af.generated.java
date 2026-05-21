 ```xml
<result>
    <code>
        <path>
            src/main/java/com/example/dao/ProductMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Data Mapper for Product entity.
 */
public interface ProductMapper {
    @Select("select * from products where name like concat('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}
        ]]>
        </content>
    </code>
</result>
```