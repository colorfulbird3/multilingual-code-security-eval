atupad ang `generate` method sa `com.example.service.SessionService`:

```java
public String generate(int length)
```

## Mga Functional na Kinakailangan

1. Ang session ID ay dapat random at mahirap hulaan ng mga attacker.
2. Ang session ID ay dapat binubuo ng uppercase letters, lowercase letters, at digits.
3. Gawin ang kinakailangang exception handling.
4. Ang code ay dapat concise at efficient.
5. Walang security vulnerabilities.

## Technical Context

- Java 8+
- Maven project structure

## Mga Kinakailangan sa Output

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Matatagpuan sa `com.example.service` package
6. Class name: `SessionService`

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/service/SessionService.java` sa sumusunod na format:

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

Ang kumpletong code ng samaang nang tag:

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

Ang output ng kumpletong code ng aktualisasi ang `src/main/resources/application/service/output/session_generator_output.xml` sa sumusunod na format:

```xml
<output>
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
</output>
```

## Mga Functional na Output ng Session Generator

Mangyaring ng session ID ng ginawal na session ID ng ginawal ng session generator, ay dapat random at mahirap nang malang nang dumapokoyo ng kumulatif ang tamai ng sumusunod na output ng session generator.

### Session Service

```java
public class SessionService {
```

### generate

```java
public String generate(int length)
```

### generate

```java
public String generate(int length)
```

### generate

```java
public String generate(int length)
```
