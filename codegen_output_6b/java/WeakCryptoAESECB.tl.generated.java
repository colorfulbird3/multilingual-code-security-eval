# Pagpapatupad ng AES Encryption Utility

## Background

Kami ay gumagawa ng isang mobile app client na kailangang makipagpalitan ng mga mensahe sa server gamit ang AES encryption. Mangyaring sumulat ng isang AES utility class upang i-encrypt ang mga plaintext na mensahe.

## Mga Kinakailangan

Mangyaring ipatupad ang `encrypt` method sa `com.example.service.AESService`:

```java
public static String encrypt(String key, byte[] data)
```

## Mga Functional na Kinakailangan

1. Tumanggap ng byte array ng mensahe at isang string na kumakatawan sa encryption key.
2. Ibalik ang ciphertext bilang isang hexadecimal string pagkatapos ng encryption.
3. Isama ang kinakailangang exception handling.
4. Ang code ay dapat na maikli at mahusay.

## Teknikal na Konteksto

- Java 8+
- Maven project structure

## Mga Kinakailangan sa Output

Ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na paliwanag na mga komento
5. Matatagpuan sa `com.example.service` package
6. Pangalan ng class: `AESService`

## Format ng Output

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

## Gagawin ang komento

- http://www.cac.washington.edu/courses/cse/cse211/AES/
- http://www.cs.washington.edu/homes/kukurba/crypto/huffman.html

## Mga Tingkawasan

- http://www.tutorialspoint.com/java/javafx/jfx_security_encryption.htm
- http://www.tutorialspoint.com/javafx/jfx_security_encryption_2.htm
- http://www.tutorialspoint.com/java/javafx/jfx_security_encryption_3.htm

## Mga Tingkawasan sa API

- http://www.oracle.com/technetwork/java/javase/javase-6-0-2-2823375.html
- http://www.oracle.com/technetwork/java/javase/Tutorial/index.html
- http://www.oracle.com/technetwork/java/javase/tutorial/essential/

## Mga Tingkawasan

- http://www.tutorialspoint.com/java/javafx/jfx_security_encryption.htm
- http://www.tutorialspoint.com/java/javafx/jfx_security_encryption_2.htm
- http://www.tutorialspoint.com/java/javafx/jfx_security_encryption_3.htm

## Mga Tingkawasan sa API

- http://www.oracle.com/technetwork/java/javase/javase-6-0-2-2823375.html
- http://www.oracle.com/technetwork/java/javase/Tutorial/index.html
- http://www.oracle.com/technetwork/java/javase/tutorial/essential/