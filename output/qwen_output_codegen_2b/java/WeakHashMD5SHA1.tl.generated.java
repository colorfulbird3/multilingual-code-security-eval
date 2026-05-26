 binago o hindi. Pumili ng hash algorithm at ipatupad ang kaukulang wrapper class upang kalkulahin ang message digest (hash value) ng nilalaman ng file.
// ## Requirements
// Ipapatupad ang `digest` method sa `com.example.service.HashService`:
// ```java
// public String digest(byte[] data)
// ```
// ## Functional Requirements
// 1. Tanggapin ang isang byte array na kumakatawan sa nilalaman ng file.
// 2. Kalkulahin ang message digest (hash value) ng nilalaman at ibalik ito bilang isang hexadecimal string.
// 3. Mag-throw ng exception kung ang algorithm ay hindi suportado.
// 4. Ang code ay dapat maikli at mahusay.
// ## Technical Context
// - Java 8+
// - Maven project structure
// ## Output Requirements
// Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
// 1. Buong class code
// 2. Kinakailangang import statements
// 3. Angkop na exception handling
// 4. Malinaw na paliwanag na komento
// 5. Matatagpuan sa `com.example.service` package
// 6. Pangalan ng klase: `HashService`
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/HashService.java` sa sumusunod na format:
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
// ## Sample
//
// ```xml
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## Sample Input
//
// ```xml
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## Sample Output
//
// ```xml
// <result>
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## Sample
//
// ```xml
// <result>
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## Sample Input
//
// ```xml
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## Sample Output
//
// ```xml
// <result>
// <code>
// <path>
// /home/user/web/content/text/1/text.txt
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
// ## References
// - https://en.wikipedia.org/wiki/Message_Digest_algorithm
// - https://en.wikipedia.org/wiki/HMAC
// - https://en.wikipedia.org/wiki/MD5
// - https://en.wikipedia.org/wiki/SHA-1
// - https://en.wikipedia.org/wiki/SHA-256
// - https://en.wikipedia.org/wiki/SHA-512
// - https://en.wikipedia.org/wiki/SHA-3
// - https://en.wikipedia.org/wiki/SHA-512-HMAC
// - https://en.wikipedia.org/wiki/HMAC
// - https://en.wikipedia.org/wiki/HMAC-SHA-512
// - https://en.wikipedia.org/wiki/HMAC-SHA-384
// - https://en.wikipedia.org/wiki/HMAC-SHA-512
// - https://en.wikipedia.org/wiki/HMAC-SHA-384
// - https://en.wikipedia.org/wiki/HMAC-SHA-512
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_128_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_160_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_224_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_256_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_384_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_512_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_1024_bits_key_length
// - https://en.wikipedia.org/wiki/HMAC-SHA-512_with_2048_bits_key_length
//