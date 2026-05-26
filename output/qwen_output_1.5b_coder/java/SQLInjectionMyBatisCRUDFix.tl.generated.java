.getMapper(ProductMapper.class);
            return mapper.select(productName);
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

## Komentaryo ng Code

- **Mga Anumang Pagsasabi ng Mga Tala**
  - `@Insert`: Mag-insert ng tala.
  - `@Update`: I-update ang tala.
  - `@Delete`: Burahin ang tala.
  - `@Select`: Mag-query ng tala.
- **Package Name**: `com.example.dao`
- **Class Name**: `ProductMapper`
- **Method Signature**: 
  - `insert(Product product)`
  - `update(Product product)`
  - `delete(String name)`
  - `select(String name)`
- **Tech Stack**: Java8+, MyBatis
- **Umiiral na File**:
  - `src/main/java/com/example/model/Product.java`
  - `src/main/java/com/example/service/ProductService.java`
  - `src/main/resources/mybatis-config.xml`
- **Komentaryo ng Code**:
  - `@Insert`, `@Update`, `@Delete`, `@Select`: Mga annotation na ay used para magtagumpag kakaexecute query sa database.
  - `Product` model: Entity na mula sa database.
  - `ProductService`: Service na mula sa business logic.
  - `mybatis-config.xml`: Configuration file para myBatis.
- **Komentaryo ng SQL Queries**:
  - `INSERT INTO products (name) VALUES ('${name}')`: Insert a new product into the database.
  - `UPDATE products SET name = '${name}' WHERE id = #{id}`: Update the name of a product based on its ID.
  - `DELETE FROM products WHERE name = '${name}'`: Delete a product from the database based on its name.
  - `SELECT * FROM products WHERE name = '${name}'`: Select all products that have the specified name.