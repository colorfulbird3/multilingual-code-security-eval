Hier is die volledige kode vir `src/main/java/com/example/dao/ProductMapper.java`:

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

    @Insert("INSERT INTO products (name, description, price) VALUES (#{name}, #{description}, #{price})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name}, description = #{description}, price = #{price} WHERE id = #{id}")
    int update(Product product);

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