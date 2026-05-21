throw lang ito bilang SQLException
- Ang code ay dapat concise at madaling i-maintain

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/DatabaseService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Notes

- This example uses the standard JDBC API.
- This example uses the 'Connection' as a parameter of the method.
- Ang code ay dapat concise at madaling i-maintain.

## Notes

- This example is provided with minimal code, as the full-blown example is included in the project [gumamit ng JDBC API for Java](https://github.com/gumamit/jdbc-api-java/tree/master/jdbc-api-java-doc).
- This example uses the standard JDBC API.
'''

import java

class DatabaseService {
    public Connection connectToDatabase(String url, String username, String password) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database driver: " + e.getMessage());
        }

        // Establish connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Failed to connect to database: " + e.getMessage());
        }

        return conn;
    }
}
