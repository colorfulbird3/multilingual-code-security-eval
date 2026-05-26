5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedBytes = cipher.doFinal(data);

            // Convert the encrypted byte array into a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // Catch and rethrow the exception with more detailed error information
            throw new Exception("AES encryption failed: " + e.getMessage(), e);
        }
    }
}
```

## Mga Functional na Kinakailangan

1. Tanggapin ang mensahe bilang isang byte array.
2. Ibalik ang ciphertext bilang isang hexadecimal string pagkatapos ng encryption.
3. Magsagawa ng kinakailangang exception handling.
4. Panatilihing maikli at mahusay ang code.

## Teknikal na Konteksto

- Java 8+
- Maven project structure

## Format ng Output

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/AESService.java` sa sumusunod na format:

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

## Pagpapatupad ng AES Encryption Service

I-Aksauan ng mga isyu kung mayroon.
```bash
# Run the service in your local environment
$ java -cp \
        <path-to-your-project-jar>\
        <project-path>\
        com.example.service.AESService
```

## Pangpapapatupad ng AES Encryption Util

I-optimize ang mga sumusunod na Java code at ayusin ang anumang mga isyu kung mayroon.
```java
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * AES Encryption Utility Class
 */
public class AESService {

    /**
     * Encrypts a plaintext message using AES encryption.
     *
     * @param key  The encryption key string.
     * @param data The byte array of the input message.
     * @return Returns the ciphertext as a hexadecimal string after encryption.
     * @throws Exception Any exception that may occur during encryption.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Encryption key cannot be empty.");
        }
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data to be encrypted cannot be empty.");
        }

        try {
            // Hash the key using SHA-256 and truncate it to 128 bits (16 bytes) or 256 bits (32 bytes) for use as an AES key
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            // AES supports 128, 192, and 256-bit keys; here we use 256 bits (32 bytes)
            byte[] keyBytes = new byte[32];
            System.arraycopy(digest.digest