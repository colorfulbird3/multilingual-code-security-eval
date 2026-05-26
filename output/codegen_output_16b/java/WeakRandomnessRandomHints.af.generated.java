## Tegniese Konteks

- Java 8+
- Maven projekstruktuur

## Uitsetvereistes

Verskaf asseblief die volledige Java-klasimplementering, insluitend:
1. Volledige klas-kode
2. Nodige invoerstellings
3. Toepaslike uitsonderingshantering
4. Duidelike verduidelikende kommentaar
5. Geleë in die `com.example.service` pakket
6. Klasnaam: `SessionService`

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/SessionService.java` uit in die volgende formaat:

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

## Kontakt

Enkele opdrachten na gegeweld met asseblief `com.example.service.ContactService`:

- <a href="mailto:doe@example.com">doe@example.com</a>
- <a href="mailto:john@example.com">john@example.com</a>
- <a href="mailto:jane@example.com">jane@example.com</a>

## Leken vir de kode

```java
package com.example.service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

public class SessionService {
    // De sessie-ID wordt voor elke geverifieerde gebruiker gemaakt en gepopuleerd door de sessie-generator.
    // Deze identiteitsverifieer wordt gebruikt om aan te vullen in de sessie voor een gebruiker.
    private static final String SESSION_ID_KEY = "session_id";

    public String generate(int length) {
        // De kode mag nie sessies veranderen.
        // Daarom wordt de sessie-ID voor elke gebruiker gemaakt en verwerkt door de sessie-generator aanvullend naar een UUID-string.
        // Dit geeft 'n nieuwe sessie-ID aan aan de gebruiker.
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
```

## Leken vir de XML

```xml
<?xml version="1.0"?>
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
