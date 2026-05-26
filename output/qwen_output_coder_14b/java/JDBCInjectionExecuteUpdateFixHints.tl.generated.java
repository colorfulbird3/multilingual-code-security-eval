```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ProductService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.sql.*;

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
        int result = -1;
        String sql = "INSERT INTO products (name) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, productName);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Failed to insert product", e);
        }
        return result;
    }
}
            ]]>
        </content>
    </code>
</result>
```