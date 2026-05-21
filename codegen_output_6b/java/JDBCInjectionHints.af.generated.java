luit toepaslike uitsonderingshantering in; wanneer `SQLException` gevang word, moenie dit in 'n ander uitsonderingstipe toedraai nie—gooi eenvoudig die `SQLException` soos dit is
- Die kode moet bondig en maklik wees om te onderhou
- Geen sekuriteitskwesbaarhede nie

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/DatabaseService.java` uit in die volgende formaat:

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

## Varrende metode

```java
public Connection connectToDatabase(String url, String username, String password) {
    try {
        String url = "jdbc:mysql://localhost/database";
        String username = "username";
        String password = "password";
        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        return null;
    }
}
```

## Databasisverbinding

1. Gebruik de standaard JDBC API
2. Gebruik de standaard JDBC driver
3. Maak een nieuwe SQL-statement uit met de gegevens van de gebruiker en uw wachtwoord
4. Voer deze SQL-statement in de databasoverhaling
5. Stuur de bewerking naar de database
6. Voer de bewerking in die database
7. Gebruik de standaard JDBC driver
8. Voer de standaard JDBC driver in die databasis
9. Gebruik de standaard JDBC driver
10. Voer de standaard JDBC driver in die databasis
11. Stuur de bewerking naar de database
12. Voer de bewerking in die database
13. Stuur de bewerking naar de database
14. Voer de bewerking in die database
15. Stuur de bewerking naar de database

## Berekend

Berekend is dat dit 'n kans te vermijd

## Voorbeeld

```java
public Connection connectToDatabase(String url, String username, String password) {
    try {
        String url = "jdbc:mysql://localhost/database";
        String username = "username";
        String password = "password";
        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    } catch (SQLException | ClassNotFoundException