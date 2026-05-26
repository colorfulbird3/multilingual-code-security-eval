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

The `Content` is returned in the `result` tag as a `<code>...</code>` element. The `code`
element contains the path of the file, and the `content` contains the code itself.
In the example above, the `content` is written as a raw code string, but the `code`
contains the file name in a String.

The `Content` will be passed into the `<result>` tag, so that we can easily reference
the source file in the generated documentation.

The `Content` is not a very useful `code` element, but it can be used to store
some other kind of data, e.g. the type of code or the encoding of the code.

*/
package code
