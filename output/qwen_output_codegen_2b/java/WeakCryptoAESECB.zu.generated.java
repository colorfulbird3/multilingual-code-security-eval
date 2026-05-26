ATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ephelele
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
//
// ## Ifomethi Yokuphuma
//
// Khipha ikhodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:
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
//
// ## Ihomba
//
// kihodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:
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
//
// ## Zokusela
//
// kihodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:
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
//
// ## Ihomba
//
// kihodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:
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
//
// ## Ihomba
//
// kihodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class AESEncoder {
    private static final int KEY_LENGTH = 16;
    private static final int IV_LENGTH = 16;
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public void encrypt(InputStream input, OutputStream output) throws IOException {
        byte[] keyBytes = readKey(input);
        byte[] ivBytes = readIv(input);
        byte[] data = readData(input);
        byte[] encryptedData = encryptData(keyBytes, ivBytes, data);
        writeData(encryptedData, output);
    }

    private byte[] readKey(InputStream input) throws IOException {
        int keyLength = (int) input.read();
        byte[] keyBytes = new byte[keyLength];
        readStream(input, keyBytes);
        return keyBytes;
    }

    private byte[] readIv(InputStream input) throws IOException {
        int ivLength = (int) input.read();
        byte[] ivBytes = new byte[ivLength];
        readStream(input, ivBytes);
        return ivBytes;
    }