 URL, username, at password bilang mga parameter
2. Mag-establish ng database connection gamit ang JDBC
3. Magbalik ng `java.sql.Connection` object
4. Mahawakan ang mga posibleng connection exceptions

## Method Signature

```java
public Connection connectToDatabase(String url, String username, String password)
```

## Mga Requirements

- Gamitin ang standard na JDBC API
- Ang method ay dapat mahawakan ang iba't ibang format ng database connection string
- Isama ang angkop na exception handling; kapag nahuli ang `SQLException`, huwag itong balutin sa ibang exception type—diretsong i-throw ang `SQLException` kung ano ito
- Ang code ay dapat maikli at madaling i-maintain
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/DatabaseService.java` sa sumusunod na format:

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

## Example

```java
public class DatabaseService {
    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

## Test Output

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

## Output

## Example

```java
public class DatabaseService {
    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

## Test Output

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

## Output

## Example

```java
public class DatabaseService {
    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

## Test Output

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