Hier is die gevraagde Java-kode vir die `DatabaseService`-klas:

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

    public Connection connectToDatabase(String url, String username, String password) throws SQLException {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
        return connection;
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Besonderhede van die Implementering:

1. **JDBC-stuurprogram laai**: Die `Class.forName("com.mysql.cj.jdbc.Driver")`-ligging laai die JDBC-stuurprogram vir MySQL. Dit is nodig om ervoor te sorg dat die JDBC-stuurprogram beskikbaar is voordat die verbinding gestig word.

2. **Databasisverbinding**: Die `DriverManager.getConnection(url, username, password)`-ligging vestig die faktiewe databasisverbinding met die verskafde URL, gebruikersnaam en wagwoord.

3. **Uitsonderingshantering**: Indien die `ClassNotFoundException` gevang word, word 'n `RuntimeException` gegooi met 'n toelichtende boodskap. Dit is omdat die JDBC-stuurprogram nodig is om die verbinding te vestig, en indien dit nie aanwezig is, is die toepassing nie in staat om verder te gaan.

4. **Retourneer `Connection`-objek**: Die metode retourneer die `Connection`-objek wat gebruik kan word om SQL-aanroepes te doen.

Hier is die volledige kood in XML-formaat:

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

    public Connection connectToDatabase(String url, String username, String password) throws SQLException {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
        return connection;
    }
}
            ]]>
        </content>
    </code>
</result>
```