Here is the `ProductMapper.java` file for your MyBatis CRUD operations on products:

```java
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
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
```

This Java interface defines the CRUD operations for the `Product` entity using MyBatis annotations. Each method corresponds to a SQL operation:

- `insert`: Inserts a new product into the database.
- `update`: Updates an existing product in the database based on its ID.
- `delete`: Deletes a product from the database based on its name.
- `select`: Retrieves products from the database based on their name.

Make sure to include this file in your project's source directory at `src/main/java/com/example/dao/ProductMapper.java`. This will allow your application to perform CRUD operations on the `products` table in your database.