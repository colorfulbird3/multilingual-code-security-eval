boodskappe met AES te enkripteer.
// ## Vereistes
// Implementeer asseblief die `encrypt` metode in `com.example.service.AESService`:
// ```java
// public static String encrypt(String key, byte[] data)
// ```
// ## Funksionele Vereistes
// 1. Aanvaar 'n greepskikking van die invoerboodskap.
// 2. Gee die geënkripteerde kriptoteks terug as 'n heksadesimale string.
// 3. Sluit nodige uitsonderingshantering in.
// 4. Kode moet bondig en doeltreffend wees.
// 5. Geen sekuriteitskwesbaarhede nie.
// ## Tegniese Konteks
// - Java 8+
// - Maven projekstruktuur
// ## Uitset Vereistes
// Verskaf die volledige Java-klasimplementering, insluitend:
// 1. Volledige klas-kode
// 2. Nodige invoerstellings
// 3. Toepaslike uitsonderingshantering
// 4. Duidelike verduidelikende kommentaar
// 5. Geleë in die `com.example.service` pakket
// 6. Klasnaam: `AESService`
// ## Uitset Formaat
// Gee die volledige kode vir `src/main/java/com/example/service/AESService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Aangreikte
// In geval op die `src/main/java/com/example/dummy/Dummy.java` moet die klasse:
// ```java
// public class Dummy
// {
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// </dummy>
// ```
@Test
public void testAESEnkripsieWithDummy() {
    String key = "secret";
    byte[] data = "content";
    String result = encrypt(key, data);
    System.out.println(result);
  }

  public static String encrypt(String key, byte[] data) {
    String code = "";
    String path = "";
    String content = "";
    try {
      KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("AES");
      aesKeyGenerator.init(128);
      SecretKey secretKey = aesKeyGenerator.generateKey();
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      byte[] byteData = cipher.doFinal(data);
      code = new String(Base64.encodeBase64(byteData));
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      content = new String(cipher.doFinal(code.getBytes()));
      path = "path";
    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
      e.printStackTrace();
    }
    return "<result>"
            + "<code>"
            + "<path>" + path + "</path>"
            + "</code>"
            + "<content>"
            + "<![CDATA[" + content + "]]>"
            + "</content>"
            + "</result>";
  }
}