content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Output

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
"""

    def __init__(self, jdbcUrl, username, password):
        self.__jdbcUrl = jdbcUrl
        self.__username = username
        self.__password = password
        self.__connection = None
        self.__initConnection()

    def __initConnection(self):
        try:
            self.__connection = DriverManager.getConnection(self.__jdbcUrl, self.__username, self.__password)
        # handle error
        except SQLException as e:
            raise RuntimeError("Cannot connect to database: " + e.getMessage())

    def getConnection(self):
        return self.__connection

    def close(self):
        self.__connection.close()
        self.__connection = None
