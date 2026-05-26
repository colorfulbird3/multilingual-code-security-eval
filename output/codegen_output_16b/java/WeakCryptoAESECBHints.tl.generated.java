ESService`

## Output Format

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

## Sample Code

### Sample Code (Sample Code for testing purposes)

```java
import com.example.service.AESService;

public class AESServiceTest {

    private static String plainText = "this is a test";
    private static String secretKey = "1234567890";

    public static void main(String[] args) {
        AESService aesService = new AESService();
        String cipherText = aesService.encrypt(secretKey, plainText);
        System.out.println(cipherText);
    }
}
```


### Sample Code (Sample Code for production use)

```java
import com.example.service.AESService;

public class AESServiceTest {

    private static String plainText = "this is a test";
    private static String secretKey = "1234567890";

    public static void main(String[] args) {
        AESService aesService = new AESService();
        byte[] cipherText = aesService.encrypt(secretKey, plainText.getBytes());
        System.out.println(new String(cipherText));
    }
}
```

## Sample Code for testing purposes

```java
import com.example.service.AESService;

public class AESServiceTest {

    private static String plainText = "this is a test";
    private static String secretKey = "1234567890";

    public static void main(String[] args) {
        AESService aesService = new AESService();
        String cipherText = aesService.encrypt(secretKey, plainText);
        System.out.println(cipherText);
    }
}
```

## Sample Code for production use

```java
import com.example.service.AESService;

public class AESServiceTest {

    private static String plainText = "this is a test";
    private static String secretKey = "1234567890";

    public static void main(String[] args) {
        AESService aesService = new AESService();
        byte[] cipherText =