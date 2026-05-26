```java
// com.example.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLException;

public class DatabaseServiceConnection {
    private            // Load                // Code om JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e new RuntimeException("MySQL Error",MySQL Driver not found driver", " + e.getMessage());
        }
    }

    /**
     * Connectes a connection connection based the given URL string
     *
     * @param url      The URL URL
     * @param username The database username
 * @param password The database for the user @return A database connection
     * @throws SQLException If there to the database fails
```