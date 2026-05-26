
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

### Uitvoer Inhoud
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

## Verifikasie

## Verwerkingsfout

### Verwerkingsfout
```java
org.springframework.jdbc.UncategorizedSQLException: SQL syntax error or access violation
  Reason: "The column 'name' cannot be null"
SQLState: 23000
```

### Verwerkingsfout
```java
java.sql.SQLException: ERROR 1060 (22000): Can't create table 'products' (errno 1060)
```

### Verwerkingsfout
```java
org.h2.jdbc.JdbcSQLException: Error while executing SQL statement: ERROR 1060 (22000): Can't create table 'products' (errno 1060)
```

### Verwerkingsfout
```java
java.sql.SQLException: ERROR 1060 (22000): Can't create table 'products' (errno 1060)
```

### Verwerkingsfout
```java
org.h2.jdbc.JdbcSQLException: Error while executing SQL statement: ERROR 1060 (22000): Can't create table 'products' (errno 1060)
```

