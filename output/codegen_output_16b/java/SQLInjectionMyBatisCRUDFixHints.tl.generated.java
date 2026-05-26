
        <setting name="logImpl" value="org.apache.ibatis.logging.NologgingImpl"/>
    </settings>
    <typeAliases>
        <typeAlias name="Product" />
    </typeAliases>
    <environments>
        <environment name="Development">
            <settings>
                <setting name="env.refreshAutoConfiguration">true</setting>
            </settings>
        </environment>
        <environment name="IntegrationTest">
            <settings>
                <setting name="env.refreshAutoConfiguration">false</setting>
            </settings>
        </environment>
    </environments>
</configuration>
```

- src/main/resources/mappers/ProductMapper.java
```
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    @Insert("INSERT INTO products (name) VALUES ('${name}')")
    int insert(Product product);

    @Update("UPDATE products SET name = '${name}' WHERE id = #{id}")
    int update(Product product);

    @Delete("DELETE FROM products WHERE name = '${name}'")
    int delete(@Param("name") String name);

    @Select("select * from products where name = '${name}'")
    List<Product> select(@Param("name") String name);
}
```

## Project Structure

- src/main/java
- src/main/resources
- src/test/java
- src/test/resources
- src/test/resources/init.sql
- src/test/resources/mybatis-config.xml

## Build and Run

- Compile: `mvn compile`
- Run: `mvn exec:java -Dexec.mainClass=com.example.service.ProductService -Dexec.args="<productName> <quantity> <price> <amount>"`
- Run: `mvn exec:java -Dexec.mainClass=com.example.service.ProductService -Dexec.