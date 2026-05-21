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

/**
 * Produkdatatoegangsvlak vir die uitvoer van CRUD-bewerkings op produkte.
 */
public interface ProductMapper {

    /**
     * Voeg 'n nuwe produkrekord in.
     *
     * @param product die produk om in te voeg
     * @return die aantal geraakte rye
     */
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    /**
     * Werk die produknaam by op grond van die produk-ID.
     *
     * @param product die produk met die opgedateerde naam
     * @return die aantal geraakte rye
     */
    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
    int update(Product product);

    /**
     * Verwyder 'n produk volgens sy naam.
     *
     * @param name die naam van die produk om te verwyder
     * @return die aantal geraakte rye
     */
    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    /**
     * Soek 'n versameling produkte met die gespesifiseerde naam (presiese passing).
     *
     * @param name die produknaam om te soek
     * @return 'n lys van produkte wat ooreenstem
     */
    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}
]]>
        </content>
    </code>
</result>
```
 */

public class ProductMapper {
    private static final String PATH_PREFIX = "src/main/java/";
    private static final String PATH_SEPARATOR = "/";
    private static final String CLASS_EXTENSION = ".java";
    private static final String PATH_SEPARATOR_CHAR = ".";

    private static final String DEFAULT_PATH_SEPARATOR = ".";

    private static final String CLASS_EXTENSION_CHAR = ".";
    private static final String PATH_SEPARATOR_STRING = ".";

    private static final String PATH_SEPARATOR_DOT = ".";
    private static final String PATH_SEPARATOR_DOT_CHAR = ".";

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_CHAR = "." + CLASS_EXTENSION_CHAR;
    private static final String PATH_SEPARATOR_CLASS_EXTENSION_STRING = "." + CLASS_EXTENSION_STRING;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION = PATH_SEPARATOR_CLASS_EXTENSION_CHAR;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_CHAR_STRING = PATH_SEPARATOR_CLASS_EXTENSION_STRING;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_STRING_STRING = PATH_SEPARATOR_CLASS_EXTENSION_STRING + CLASS_EXTENSION_STRING;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_STRING_CHAR = PATH_SEPARATOR_CLASS_EXTENSION_STRING + CLASS_EXTENSION_CHAR;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_CHAR_STRING = PATH_SEPARATOR_CLASS_EXTENSION_CHAR + CLASS_EXTENSION_STRING;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_CHAR_CHAR = PATH_SEPARATOR_CLASS_EXTENSION_CHAR + CLASS_EXTENSION_CHAR;

    private static final String PATH_SEPARATOR_CLASS_EXTENSION_CHAR_STRING_CHAR = PATH_