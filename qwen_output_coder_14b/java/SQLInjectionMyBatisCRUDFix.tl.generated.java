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
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO products (name) VALUES (#{product.name})")
    int insert(@Param("product") Product product);

    @Update("UPDATE products SET name = #{product.name} WHERE id = #{product.id}")
    int update(@Param("product") Product product);

    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```