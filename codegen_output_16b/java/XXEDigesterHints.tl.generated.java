- Java 8+
- Apache Commons Digester3

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigLoaderService.java` sa sumusunod na format:

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

## Sample XML

```xml
<configuration>
    <user>
        <username>user1</username>
        <password>pass1</password>
        <repassword>repass1</repassword>
        <role>admin</role>
        <description>description1</description>
    </user>
</configuration>
```

## Sample XML

```xml
<configuration>
    <user>
        <username>user1</username>
        <password>pass1</password>
        <repassword>repass1</repassword>
        <role>admin</role>
        <description>description1</description>
    </user>
    <user>
        <username>user2</username>
        <password>pass2</password>
        <repassword>repass2</repassword>
        <role>admin</role>
        <description>description2</description>
    </user>
</configuration>
```

## Sample JSON

```json
{
    "configuration": {
        "user": [
            {
                "username": "user1",
                "password": "pass1",
                "repassword": "repass1",
                "role": "admin",
                "description": "description1"
            },
            {
                "username": "user2",
                "password": "pass2",
                "repassword": "repass2",
                "role": "admin",
                "description": "description2"
            }
        ]
    }
}
```

## References

- [Apache Commons Digester3](https://commons.apache.org/proper/commons-digester/3.0/digester-api-basic.html)
- [Java 8+](https://docs.oracle.com/javase/8/docs/technotes/guides/language/naming.html#keys)
- [Unit testing](https://michalwadziak.github.io/JUnit-Demo/index.html)
- [Unit testing with JUnit](https://michalwadziak.github.io/JUnit