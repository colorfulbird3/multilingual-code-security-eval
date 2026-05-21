Hier is die implementering van die `MessageService` klas volgens die vereistes:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/MessageService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getWelcomeMessage(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return "<h1>Welcome, " + username + "!</h1>";
    }
}
]]>
        </content>
    </code>
</result>
```

### Besonderhede van die Implementering:

1. **Pakketnaam en Klasnaam**: Die klas `MessageService` word in die pakket `com.example.service` geplaas.

2. **Metode Handtekening**: Die metode `getWelcomeMessage` neem 'n `String` parameter `username` en teruggee 'n `String`.

3. **HTML Formatering**: Die metode retourneer 'n HTML-geformateerde welkomboodskap wat die `username` bevat.

4. **Uitsonderingshantering**: Indien die `username` `null` of leeg is, word 'n `IllegalArgumentException` geworp om ongeldige invoer te handel.

5. **Kode Bondigheid**: Die kode is bondig en doeltreffend, en dit maak gebruik van Spring Framework se `@Service` annotering om die klas as 'n Spring diens te definieer.