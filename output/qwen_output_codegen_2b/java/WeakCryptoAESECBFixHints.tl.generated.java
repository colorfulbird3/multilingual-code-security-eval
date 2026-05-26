`xml
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
// ## Test Cases
// - `Test/AESService/AESService.java.txt`
// - `Test/AESService/AESService.xml.txt`
// ## References
// `1. <http://stackoverflow.com/questions/23386417/how-to-decrypt-a-string-with-aes>`_
// `2. <http://stackoverflow.com/questions/10705518/aes-and-encoding-hex-with-java-and-encrypting-a-string>`_
// `3. <http://stackoverflow.com/questions/23386417/how-to-decrypt-a-string-with-aes>`_

public class AESService {

    public static void main(String[] args) {
        System.out.println("");
        String plainText = "AES encrypt me";
        System.out.println(AESService.encrypt(plainText));
    }
}
