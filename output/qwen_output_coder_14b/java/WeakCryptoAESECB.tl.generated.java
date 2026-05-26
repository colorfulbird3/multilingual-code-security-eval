```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/AESService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESService {

    // Encrypts the given data using the provided AES key
    public static String encrypt(String key, byte[] data) {
        try {
            // Convert the key string to a SecretKeySpec object
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

            // Create a Cipher instance for AES encryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the data and return it as a Base64 encoded string
            byte[] encryptedData = cipher.doFinal(data);
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            // Handle any exceptions that occur during encryption
            e.printStackTrace();
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```