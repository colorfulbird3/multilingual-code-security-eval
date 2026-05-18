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

public interface ProductMapper {

    /**
     * Magsagawa ng fuzzy query batay sa pangalan ng produkto (name)
     * @param name Ang pangalan ng produkto na hahanapin
     * @return Listahan ng mga produktong tugma
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```