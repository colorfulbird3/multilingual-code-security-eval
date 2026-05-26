

- src/main/java/com/example/model/Product.java
```java
package com.example.model;

/**
 * Represents a product entity.
 */
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
```

- src/main/resources/init.sql
```
CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255),
                          price DECIMAL(10, 2)
);

INSERT INTO products (name) VALUES ('Laptop');
INSERT INTO products (name) VALUES ('Mouse');
INSERT INTO products (name) VALUES ('Keyboard');
```

## Okuqumizwa
- src/main/java/com/example/service/ProductService.java
```java
package com.example.service;

import java.sql.*;

public class ProductService {

    private String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'