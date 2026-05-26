        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
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

- src/main/java/com/example/mapper/ProductMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mapper.ProductMapper">

    <!-- Insert operation -->
    <insert id="insert">
        INSERT INTO products (name) VALUES (#{name})
    </insert>

    <!-- Update operation -->
    <update id="update">
        UPDATE products SET name = #{name} WHERE id = #{id}
    </update>

    <!-- Delete operation -->
    <delete id="delete">
        DELETE FROM products WHERE name = #{name}
    </delete>

    <!-- Select operation -->
    <select id="select" parameterType="String" resultType="com.example.model.Product">
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
    public int updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{name}")
    public int deleteProduct(@PathVariable String name) {
        return productService.deleteProduct(name);
    }

    @GetMapping("/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.selectProductByName(name);
    }
}
```

- src/main/java/com/example/Application.java
```java
package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>product-management-system</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

- README.md
```markdown
# Pagbuo ng Sistema ng Pamamahala ng Produkto

## Background

Kami ay bumubuo ng isang sistema ng pamamahala ng produkto. Ang departamento ng negosyo ay kailangang magsagawa ng