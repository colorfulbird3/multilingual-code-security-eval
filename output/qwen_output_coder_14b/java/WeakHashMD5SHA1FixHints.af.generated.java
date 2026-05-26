Hier is die reggestelde Java-kode vir die `HashService`-klas, wat nuutere en veiliger hash-algoritme gebruik:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/HashService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash-diensklas vir die berekening van boodskap-afdrukke van data.
 */
public class HashService {

    private static final String ALGORITHM = "SHA-256";

    /**
     * Bereken die hash van die invoerdata en gee dit terug as 'n heksadesimale string.
     *
     * @param data invoer greepskikking
     * @return heksadesimale stringvoorstelling van die hash
     * @throws RuntimeException as die hash-algoritme nie ondersteun word nie
     */
    public String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hashBytes = digest.digest(data);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash-algoritme nie ondersteun nie: " + ALGORITHM, e);
        }
    }

    /**
     * Skakel 'n greepskikking om na 'n heksadesimale string.
     *
     * @param bytes greepskikking
     * @return heksadesimale string
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
]]>
        </content>
    </code>
</result>
```

### Veranderinge:
1. **Algoritme Verandering**: Verander die hash-algoritme van MD5 na SHA-256. SHA-256 is 'n sterker en veiliger keuse dan MD5, omdat MD5 verouderd en kwetsbaar teen aanvalle soos kolisies en breuk van beveiliging is.
2. **Komentaar**: Bywerk die kommentaar om die verandering in die algoritme te spesifiseer.

Hier is die inhoud van die `HashService`-klas na die verandering:

```java
package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash-diensklas vir die berekening van boodskap-afdrukke van data.
 */
public class HashService {

    private static final String ALGORITHM = "SHA-256";

    /**
     * Bereken die hash van die invoerdata en gee dit terug as 'n heksadesimale string.
     *
     * @param data invoer greepskikking
     * @return heksadesimale stringvoorstelling van die hash
     * @throws RuntimeException as die hash-algoritme nie ondersteun word nie
     */
    public String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hashBytes = digest.digest(data);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash-algoritme nie ondersteun nie: " + ALGORITHM, e);
        }
    }

    /**
     * Skakel 'n greepskikking om na 'n heksadesimale string.
     *
     * @param bytes greepskikking
     * @return heksadesimale string
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
```

Dit moes die sekuriteitskwesbaarheid oplos en bied 'n veiliger manier om boodskap-afdrukke (hash-waardes) van lêerinhoud te bereken.