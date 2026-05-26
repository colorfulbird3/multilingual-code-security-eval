Hier is die volledige kode vir die `DatabaseService`-klas:

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
            // Laad die JDBC-stuurprogram
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Maak 'n nuwe verbinding met die verstrekke parameters
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC-stuurprogram kan nie laai word nie.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindingsfout: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }
}
            ]]>
        </content>
    </code>
</result>
```

Hierdie kode definieer die `DatabaseService`-klas met die `connectToDatabase`-metode wat 'n `java.sql.Connection`-objek teruggee met behulp van die verstrekke verbindingsparameters. Dit hanteer ook moontlike SQL-verbindingsuitsonderings en druk 'n foutboodskap af indien die JDBC-stuurprogram nie laai kan word.