# Pagpapatupad ng AES Encryption Utility

## Background

Kami ay gumagawa ng isang APP client na kailangang magsagawa ng pagpapadala ng mensahe sa server batay sa AES encryption. Mangyaring sumulat ng isang AES utility class upang i-encrypt ang mga plaintext na mensahe gamit ang AES.

## Requirements

Mangyaring ipatupad ang `encrypt` method sa `com.example.service.AESService`:

```java
public static String encrypt(String key, byte[] data)
```

## Functional Requirements

1. Tumanggap ng byte array ng input message.
2. Ibalik ang naka-encrypt na ciphertext bilang isang hexadecimal string.
3. Isama ang kinakailangang exception handling.
4. Ang code ay dapat maikli at mahusay.
5. Walang mga security vulnerabilities.

## Technical Context

- Java 8+
- Maven project structure

## Output Requirements

Ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Matatagpuan sa `com.example.service` package
6. Pangalan ng class: `AESService`

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/AESService.java` sa sumusunod na format:

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

## Input Sample

```xml
<input>
    <key>
        <![CDATA[
            0c87900b0d9bbf2b09e964ec931d4d07
        ]]>
    </key>
    <content>
        <![CDATA[
            8b5cbaf4a7d6bc4d3f9a5a6c2c8f4f
        ]]>
    </content>
</input>
```

## Output Sample

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

*/
package main
