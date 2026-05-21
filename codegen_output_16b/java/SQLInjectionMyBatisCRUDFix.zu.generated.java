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

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
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

When using this template, you must provide an `id` field.

@see https://mybatis.org/mybatis-generator/mybatis.html#_result_map_templates
@see https://mybatis.org/mybatis-generator/mybatis.html#_codegen_templates
@see https://mybatis.org/mybatis-generator/mybatis.html#_xml_templates
*/
package com.example.dao;
