Hier is die volledige Java-klasimplementering vir `src/main/java/com/example/service/HashService.java`:

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
     * Bereken die boodskap-opsomming (hashwaarde) van die gegee lêerinhoud.
     *
     * @param data die lêerinhoud om te hash
     * @return die heksadesimale string van die hashwaarde
     * @throws IllegalStateException asseblief wanneer die algoritme nie ondersteun word nie
     */
    public String digest(byte[] data) {
        try {
            // Gebruik SHA-256 algoritme vir die hashwaarde
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data);
            
            // Konverteer die byte-array na 'n heksadesimale string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algoritme word nie ondersteun nie", e);
        }
    }
}
]]></content>
    </code>
</result>
```

### Verduidelikende Kommentaar

1. **Package Declaration**: Die klasse word in die `com.example.service` pakket geplaas.
2. **Class Definition**: Die `HashService` klasse word gedefinieer.
3. **Method Definition**: Die `digest` metode word gedefinieer om die boodskap-opsomming (hashwaarde) van die gegee lêerinhoud te bereken.
   - **Parameters**: 'n `byte[]` parameter genaamd `data` word aan die metode gegee.
   - **Return Value**: Die metode gee 'n heksadesimale string van die hashwaarde terug.
   - **Exception Handling**: Asseblief '