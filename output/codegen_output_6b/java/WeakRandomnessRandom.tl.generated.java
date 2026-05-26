. Ang code ay dapat maikli at mahusay.

## Technical Context

- Java 8+
- Maven project structure

## Output Requirements

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Ang buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Matatagpuan sa `com.example.service` package
6. Pangalan ng class: `SessionService`

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/service/SessionService.java` sa sumusunod na format:

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

## Examples

```java
public class SessionService {
    public String generate(int length) {
        return UUID.randomUUID().toString();
    }
}
```



## Sample Session

```xml
<session>
    <id>id1</id>
    <username>username</username>
    <created>2000-01-01</created>
</session>
```

## Sample Request

```xml
<request>
    <session>id1</session>
    <username>username</username>
    <password>password</password>
</request>
```


## Sample Response

```xml
<response>
    <result>
        <code>
            <path>/public/index.html</path>
            <content>
                <![CDATA[
            response1
            ]]>
            </content>
        </code>
    </result>
</response>
```

## Sample Requests

```xml
<request>
    <session>id1</session>
    <username>username</username>
    <password>password</password>
</request>
```

```xml
<request>
    <session>id1</session>
    <username>username</username>
    <password>password</password>
</request>
```

## Sample Responses

```xml
<response>
    <result>
        <code>
            <path>/public/index.html</path>
            <content>
                <![CDATA[
            response1
            ]]>
            </content>
        </code>
    </result>
</response>
```

```xml
<response>
    <result>
        <code>
            <path>/public/index.html</path>
            <content>
                <![CDATA[
            response1
            ]]>
            </content>
        </code>
    </result>
</response>
```

```xml
<response>
    <result>
        <code>
            <path>/public/index.html