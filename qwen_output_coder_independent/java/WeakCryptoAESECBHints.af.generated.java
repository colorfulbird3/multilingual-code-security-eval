Hier is die volledige Java-klasimplementering voor die `AESService` klasse:

```xml
<result>
    <code>
        <path>src/main/java/com/example/service/AESService.java</path>
        <content><![CDATA[
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESService {

    /**
     * Encrypts the input message using AES encryption.
     *
     * @param key The encryption key.
     * @param data The data to be encrypted.
     * @return The encrypted data as a hexadecimal string.
     */
    public static String encrypt(String key, byte[] data) {
        try {
            // Create a SecretKeySpec object from the key
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            // Create a Cipher object for AES encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the data
            byte[] encryptedData = cipher.doFinal(data);

            // Convert the encrypted data to a hexadecimal string
            return bytesToHex(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    /**
     * Converts a byte array to a hexadecimal string.
     *
     * @param bytes The byte array to convert.
     * @return The hexadecimal string representation of the byte array.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
]]>
        </content>
    </code>
</result>
```

### Uitleg

1. **encrypt Methode**:
   - Accepteer 'n sleutel en 'n byte-matrix as invoer.
   - Maak 'n `SecretKeySpec` objek van die sleutel.
   - Skep 'n `Cipher` objek vir AES-versleuteling.
   - Versleutel die data.
   - Skakel die versleutelde data om na 'n hexadec