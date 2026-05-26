.getMapper(ProductMapper.class);
            return mapper.selectByProductName(productName);
        }
    }
}
```
- src/main/resources/mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/your_database"/>
                <property name="username" value="your_username"/>
                <property name="password" value="your_password"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="com/example/mapper/ProductMapper.xml"/>
    </mappers>
</configuration>
```
- src/main/resources/com/example/mapper/ProductMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.ProductMapper">

    <insert id="insert" parameterType="com.example.model.Product">
        INSERT INTO products (name) VALUES (#{name})
    </insert>

    <update id="update" parameterType="com.example.model.Product">
        UPDATE products SET name = #{name} WHERE id = #{id}
    </update>

    <delete id="delete" parameterType="String">
        DELETE FROM products WHERE name = #{name}
    </delete>

    <select id="selectByProductName" parameterType="String" resultType="com.example.model.Product">
        SELECT * FROM products WHERE name LIKE CONCAT('%', #{productName}, '%')
    </select>

</mapper>
```
- src/main/resources/com/example/controller/ProductController.java
```java
package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public int createProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/{id}")
    public int updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{name}")
    public int deleteProduct(@PathVariable String name) {
        return productService.deleteProduct(name);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.selectAllProducts();
    }

    @GetMapping("/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.selectProductByName(name);
    }
}
```
- src/main/resources/application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
mybatis.mapper-locations=classpath*:com/example/mapper/*.xml
```

---

This Java code snippet demonstrates how to implement a CRUD (Create, Read, Update, Delete) system using MyBatis in a Spring Boot application. The `Product` model represents the data structure of a product, and the `ProductService` handles database operations such as inserting, updating, deleting, and selecting products based on their names. The `ProductController` provides RESTful endpoints for interacting with these operations.