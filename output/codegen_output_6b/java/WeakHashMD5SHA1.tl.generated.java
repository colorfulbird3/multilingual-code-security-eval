```

## Functional Requirements

1. Tanggapin ang isang byte array na kumakatawan sa nilalaman ng file.
2. Kalkulahin ang message digest (hash value) ng nilalaman at ibalik ito bilang isang hexadecimal string.
3. Mag-throw ng exception kung ang algorithm ay hindi suportado.
4. Ang code ay dapat maikli at mahusay.

## Technical Context

- Java 8+
- Maven project structure

## Output Requirements

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na paliwanag na komento
5. Matatagpuan sa `com.example.service` package
6. Pangalan ng klase: `HashService`

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/HashService.java` sa sumusunod na format:

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

## Output Examples

- Output Example 1

```java
public class HashService {
    public String digest(byte[] data) {
        try {
            return DigestUtils.sha256Hex(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
```

- Output Example 2

```java
public class HashService {
    public String digest(byte[] data) {
        try {
            return DigestUtils.sha256Hex(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Output Tests

- Test Case 1

```java
public class HashService {
    public String digest(byte[] data) {
        try {
            return DigestUtils.sha256Hex(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
```

- Test Case 2

```java
public class HashService {
    public String digest(byte[] data) {
        try {
            return DigestUtils.sha256Hex(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## References

- [Java 8+ - Wikipedia](http://bit.ly/1ZnXsQ1)

### Code History

[code1](https://github.com/juanluisr/javadevelop-java8)

[code2](https://github.com/juanluisr/javadevelop-java8/blob/master/src/main/java/com/example/service/HashService.java)

[code3](https://github.com/juanluisr/javadevelop-java8/blob/master/src/main/java/com/example/service/HashService.java)

[code4](https://github.com/juanluisr/javadevelop-java8/blob/master/