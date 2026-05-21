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
 * Data Mapper vir Produk-entiteite.
 */
public interface ProductMapper {
    @Select("select * from products where name like '%' || #{name} || '%'")
    List<Product> searchByName(@Param("name") String name);
}
        ]]>
        </content>
    </code>
</result>
```
 */
public interface ProductMapper {

    /**
     * Selects a product by primary key.
     *
     * @param id the product identifier
     * @return the found product, or null if not found
     */
    Product selectByPrimaryKey(Long id);

    /**
     * Selects a product by key.
     *
     * @param key the product key
     * @return the found product, or null if not found
     */
    Product selectByKey(Long key);

    /**
     * Inserts a product.
     *
     * @param product the product
     * @return the generated identifier
     */
    long insert(Product product);

    /**
     * Updates a product.
     *
     * @param product the product
     * @return the number of affected rows
     */
    int update(Product product);

    /**
     * Deletes a product by primary key.
     *
     * @param id the product identifier
     * @return the number of affected rows
     */
    int delete(Long id);

    /**
     * Deletes a product by key.
     *
     * @param key the product key
     * @return the number of affected rows
     */
    int deleteByKey(Long key);
}
