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
     * Voer 'n wasige soektog uit gebaseer op die produknaam (name)
     * @param name Die produknaam om na te soek
     * @return Lys van ooreenstemmende produkte
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}
]]>
        </content>
    </code>
</result>
```