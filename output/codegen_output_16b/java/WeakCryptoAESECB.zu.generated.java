ES encryption. Sicela ubhale i-AES utility class ukubethela imiyalezo ecacile.

## Izidingo

Sicela usebenzise indlela `encrypt` ku `com.example.service.AESService`:

```java
public static String encrypt(String key, byte[] data)
```

## Izidingo Zokusebenza

1. Yamukela i-byte array yomlayezo kanye nochungechunge olumele ukhiye wokubethela.
2. Buyisela i-ciphertext njengochungechunge lwe-hexadecimal ngemuva kokubethela.
3. Faka ukuphathwa kwezimo ezingajwayelekile okudingekayo.
4. Ikhodi kufanele ibe mfushane futhi isebenze kahle.

## Isimo Sobuchwepheshe

- Java 8+
- Isakhiwo se-Maven project

## Izidingo Zokuphuma

Hlinzeka ngokuqaliswa okuphelele kweklasi le-Java, okuhlanganisa:
1. Ikhodi ephelele yeklasi
2. Izitatimende ezidingekayo zokungenisa
3. Ukuphathwa kwezimo ezingajwayelekile okufanele
4. Amazwana achazayo acacile
5. Itholakala kuphakheji `com.example.service`
6. Igama leklasi: `AESService`

## Ifomethi Yokuphuma

Khipha ikhodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:

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

## Ifomethi Zokuphuma

Kipha ikhodi ezilingizimela:

```java
import org.apache.commons.codec.binary.Base64;
import com.example.service.AESService;

public class AESServiceImpl implements AESService {

    public static void main(String[] args) {
        byte[] key = Base64.decodeBase64("YmMmMdYxOTk=");
        byte[] data = "I'm a test".getBytes();
        byte[] ciphertext = AESServiceImpl.encrypt(key, data);
        System.out.println(Base64.encodeBase64String(ciphertext));
        byte[] plaintext = AESServiceImpl.decrypt(key, ciphertext);
        System.out.println(new String(plaintext));
    }

    public static byte[] encrypt(byte[] key, byte[] data) {
        byte[] ciphertext = null;
        try {
            ciphertext = AESHelper.encrypt(key, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciphertext;
    }

    public static byte[] decrypt(byte[] key, byte[] ciphertext) {
        byte[] plaintext = null;
        try {
            plaintext = AESHelper.decrypt(key, ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plaintext;
    }
}
```

## Ifomethi Yokuphuma

Kipha ikhodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:

```java
import org.apache.commons.codec.binary.Base64;
import com.example.service.AESService;

public class AESServiceImpl implements AESService {

    public static void main(String[] args) {
        byte[] key = Base64.decodeBase64("YmMmMdYxOTk=");
        byte