configuration>
    <typeAliases>
        <typeAlias alias="Product">com.example.model.Product</typeAlias>
    </typeAliases>
</configuration>
```

## Okukupa Endukiswa

- src/main/java/com/example/dao/ProductMapper.java
```java
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int insert(Product product);

    int update(Product product);

    int delete(@Param("name") String name);

    List<Product> select(@Param("name") String name);
}
```
- src/main/resources/mybatis-config.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias alias="Product">com.example.model.Product</typeAlias>
    </typeAliases>
</configuration>
```

## Okupa Endlela
- src/main/java/com/example/service/ProductService.java
```java
package com.example.service;

import com.example.dao.ProductMapper;
import com.example.model.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProductService {

    private static final SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new