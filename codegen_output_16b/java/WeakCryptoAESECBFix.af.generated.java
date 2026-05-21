

## Uitvoer in de App

Voer die volgende enkele regel in `src/main/java/com/example/service/App.java`:

```java
import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Enkripsie die boodskap.
            String key = "My_secret_key";
            String data = "This_is_my_data";

            System.out.println("Original text: " + data);

            byte[] encrypted = AESService.encrypt(key, data.getBytes());
            System.out.println("Encrypted text: " + new String(encrypted, "UTF-8"));

            // De opvolgende uitset-aanduiding is bestaan uit 'n enkele regel die nie de volgende code zal afvang.
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Couldn't find SHA-256", e);
        }
    }
}
```

### Uitvoer in die URL

Verwys de enkele regel in die URL en voer de opvolgende code weer uit.

```java
http://localhost:8080/AESService
```

### Uitvoer in de App

Verwys de enkele regel in die App en voer de opvolgende code weer uit.

```java
http://localhost:8080/AESService
```
