```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/DatabaseService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
        return connection;
    }
}
            ]]>
        </content>
    </code>
</result>
```