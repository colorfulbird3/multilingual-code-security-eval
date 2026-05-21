 kung ano ito
- Ang code ay dapat maikli at madaling mapanatili

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

## References

- [How To Connect to a MySQL Database](https://devcenter.heroku.com/articles/connecting-to-a-mysql-database-with-java)
- [MySQL Driver](https://devcenter.heroku.com/articles/connecting-to-a-mysql-database-with-java#mysql-driver)

## Developed and tested with

- Java SE 8
- Oracle 11g
- Oracle Client 11g
"""


def main():
    """Main function"""

    # Functionality
    functionality()

    # Output
    print(__doc__)


def functionality():
    """Functionality section"""

    # Input
    url = input("Input server url: ")
    username = input("Input username: ")
    password = input("Input password: ")

    # Validation
    if url is None or username is None or password is None:
        print("Invalid input!")
        exit()

    # Database connection
    connection = connectToDatabase(url, username, password)

    # Query
    query = "SELECT * FROM USERS WHERE ID = %s" % input("Input user id: ")
    result = executeQuery(query, connection)

    # Output
    print("Database query result: ")
    print(result)


def connectToDatabase(url, username, password):
    """Database connection"""

    # Validation
    if url is None or username is None or password is None:
        print("Invalid input!")
        exit()

    # Database connection
    try:
        return DriverManager.getConnection(url, username, password)
    except SQLException as e:
        print("Error connecting to database: " + e.getMessage())
        exit()


def executeQuery(query, connection):
    """Execute database query"""

    # Validation
    if query is None:
        print("Invalid input!")
        exit()

    # Query
    try:
        return connection.createStatement().executeQuery(query)
    except SQLException as e:
        print("Error executing query: " + e.getMessage())
        exit()


if __name__ == "__main