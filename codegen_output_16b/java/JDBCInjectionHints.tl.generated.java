 itong balutin sa ibang exception type—diretsong i-throw ang `SQLException` kung ano ito
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

## Testing

Laktawin ang mga output sa `src/test/java/com/example/service/DatabaseServiceTest.java` sa sumusunod na format:

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

## References

- https://www.tutorialspoint.com/jdbc/jdbc-connect-mysql.htm
- https://www.tutorialspoint.com/jdbc/jdbc-connect-oracle.htm
- https://www.tutorialspoint.com/jdbc/jdbc-connect-postgresql.htm
- https://www.tutorialspoint.com/jdbc/jdbc-connect-sqlserver.htm

## Sample Database Connection URL

`jdbc:mysql://localhost:3306/mydatabase?useSSL=false&useSSL=true&useSSL=false

## Sample Database Connection URL

`jdbc:oracle:thin:@localhost:1521:XE

## Sample Database Connection URL

`jdbc:postgresql://localhost:5432/mydatabase?ssl=false

## Sample Database Connection URL

`jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks

## Sample Database Connection URL

`jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;integratedSecurity=true

## Sample Database Connection URL

`jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;integratedSecurity=true;encrypt;trustServerCertificate=false;trustStore=/my_trust_store;trustStorePassword=mypassword

## Sample Database Connection URL

`jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;integratedSecurity=true;encrypt;trustServerCertificate=false;trustStore=/;trustStorePassword=mypassword

## Sample Database Connection URL

`jdbc:sqlserver://localhost:1433