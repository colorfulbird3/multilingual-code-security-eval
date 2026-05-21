Hier is die geregmaakte Java-kode vir die `ProductService`-klas om SQL-injection te voorkom:

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

### Verklaring van veranderinge:

1. **PreparedStatement Gebruik**: 
   - Oorspronklike SQL-instructie is verander om gebruik te maak van `PreparedStatement`. Dit word gebruik om parameterwaardes veilig in die SQL-instructie te voeg, wat SQL-injection aanmoedig.
   
2. **Parameter Binding**:
   - `pstmt.setString(1, productName)` bind die `productName`-waarde aan die eerste parameter van die SQL-instructie (`?`).

3. **Exception Handling**:
   - Die `SQLException` is omsluit met 'n `Exception` met 'n boodskap om 'n beter begrip van die fout te verskaf.

4. **Return Value**:
   - Die `result` variabele word nuut ingestel met die aantal gewerkte rekele, wat `pstmt.executeUpdate()` terug gee. Dit kan nuttig wees om te bevestig dat die insinering suksesvol was.

Hier is die volledige geregmaakte kodelys vir `ProductService.java`:

```java
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
```

Dit reggemaakte kodelys maak gebruik van `PreparedStatement` om SQL-injection te voorkom en bied 'n beter manier om SQL-instructies veilig en effektief uit te voer.