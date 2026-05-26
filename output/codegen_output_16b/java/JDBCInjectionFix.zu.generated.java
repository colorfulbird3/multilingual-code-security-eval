

## Ukuthukise

```java
public void run() {
    //...
    DatabaseService svc = new DatabaseService();
    Connection conn = svc.connectToDatabase("jdbc:mysql://localhost/MyDB", "myUserName", "myPassword");
    //...
}
```

## Isendlalelo

Implementing the DatabaseService:

```java
public class DatabaseService {
    Connection connectToDatabase(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
```

## Ezikhomi

```java
public class DatabaseService {
    static {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database driver: " + e.getMessage());
        }
    }

    public void run() {
        //...
        DatabaseService svc = new DatabaseService();
        Connection conn = svc.connectToDatabase("jdbc:mysql://localhost/MyDB", "myUserName", "myPassword");
        //...
    }
}
```

## Isendlalelo

Creating a DB schema:

```sql
CREATE TABLE IF NOT EXISTS `MyTable` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(32) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

## Izidingo

- Sebenzisa i-JDBC API evamile
- Indlela kufanele iphathe izinhlobo ezahlukene zamafomethi we-string yokuxhuma kudathabheysi
- Ukuphathwa kwezimo eziphuthumayo okufanele kuyandingeka; uma ubamba i-SQLException, ungayifaka kwen