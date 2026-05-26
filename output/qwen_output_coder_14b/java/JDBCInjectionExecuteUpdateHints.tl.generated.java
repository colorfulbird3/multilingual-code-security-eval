```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ProductService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductService {

    private String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private String username = "root";
    private String password = "@#Heydg_3^53s";
    private Connection connection;

    public ProductService() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(String productName) throws Exception {
        String sql = "INSERT INTO products (name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productName);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error inserting product", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```