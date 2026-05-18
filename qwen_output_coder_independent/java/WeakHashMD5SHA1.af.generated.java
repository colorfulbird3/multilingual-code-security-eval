Hier is een voorbeeld van hoe je de `HashService` klasse kunt implementeren in Java. In dit voorbeeld gebruiken we het SHA-256 algoritme om de hash-waarde van de lêerinhoud te berekenen. We gebruiken de `MessageDigest` klasse uit de Java Security API om dit te doen.

```xml
<result>
    <code>
        <path>src/main/java/com/example/service/HashService.java</path>
        <content><![CDATA[
package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    /**
     * Bereken die SHA-256 hash-waarde van die gegee byte[] data.
     *
     * @param data die byte[] data om te hash
     * @return die heksadesimale string van die hash-waarde
     * @throws NoSuchAlgorithmException asseblief wanneer die SHA-256 algoritme nie beskikbaar is nie
     */
    public String digest(byte[] data) throws NoSuchAlgorithmException {
        // Maak 'n MessageDigest instance vir die SHA-256 algoritme
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Bereken die hash-waarde van die data
        byte[] hashBytes = md.digest(data);

        // Konverteer die byte[] hash-waarde na 'n heksadesimale string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
]]></content>
    </code>
</result>
```

### Uitleg van die kode:

1. **Package en Imports**:
   - Die `HashService` klasse is in die `com.example.service` pakket geplaas.
   - Die `MessageDigest` en `NoSuchAlgorithmException` klasse word ingevoer om die SHA-256 algoritme te gebruik.

2. **digest-metode**:
   - Die `digest` metode neem 'n `byte[]` parameter genaamd `data`.
   - 'n `MessageDigest` instance word gemaak vir die SHA-256