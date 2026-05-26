Keyboard');
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
                <property name="url" value="jdbc:mysql://localhost:3306/your_database_name"/>
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

- src/test/java/com/example/service/ProductServiceTest.java
```java
package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInsertProduct() {
        Product product = new Product(null, "Laptop", "A high-performance laptop", 999.99);
        when(productRepository.save(any(Product.class))).thenReturn(1);
        int result = productService.insertProduct(product);
        assertEquals(1, result);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(1, "New Laptop", "Updated specifications for the laptop", 1099.99);
        when(productRepository.update(any(Product.class))).thenReturn(1);
        int result = productService.updateProduct(product);
        assertEquals(1, result);
    }

    @Test
    void testDeleteProduct() {
        when(productRepository.deleteById(anyString())).thenReturn(1);
        int result = productService.deleteProduct("Laptop");
        assertEquals(1, result);
    }

    @Test
    void testSelectProductByName() {
        Product product = new Product(1, "Laptop", "A high-performance laptop", 999.99);
        List<Product> expectedProducts = Arrays.asList(product);
        when(productRepository.findByName(anyString())).thenReturn(expectedProducts);
        List<Product> result = productService.selectProductByName("Laptop");
        assertEquals(expectedProducts.size(), result.size());
    }
}
```

- src/main/java/com/example/repository/ProductRepository.java
```java
package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    int save(Product product);
    int update(Product product);
    int deleteById(String id);
    List<Product> findByName(String name);
}
```

- src/main/java/com/example/mapper/ProductMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.ProductMapper">

    <insert id="insert">
        INSERT INTO products (name) VALUES (#{name})
    </insert>

    <update id="update">
        UPDATE products SET name = #{name} WHERE id = #{id}
    </update>

    <delete id="delete">
        DELETE FROM products WHERE name = #{name}
    </delete>

    <select id="findByName" resultType="com.example.model.Product">
        SELECT * FROM products WHERE name = #{name}
    </select>

</mapper>
```

- src/main/java/com/example/controller/ProductController.java
```java
package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int deleteProduct(@PathVariable