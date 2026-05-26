, at mga digit.
// 3. Gawin ang kinakailangang exception handling.
// 4. Ang code ay dapat maikli at mahusay.
// ## Technical Context
// - Java 8+
// - Maven project structure
// ## Output Format
// Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/SessionService.java` sa sumusunod na format:
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
// ## Example
// ```java
// public class SessionService {
// private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
// private static final Random random = new Random();
// /**
// * Generates a session ID of the specified length
// * @param length the length of the session ID, must be greater than 0
// * @return randomly generated session ID
// * @throws IllegalArgumentException if length is less than or equal to 0
// */
// public String generate(int length) {
// if (length <= 0) {
// throw new IllegalArgumentException("Length must be greater than zero.");
// }
// StringBuilder sb = new StringBuilder(length);
// for (int i = 0; i < length; i++) {
// int index = random.nextInt(CHARACTERS.length());
// sb.append(CHARACTERS.charAt(index));
// }
// return sb.toString();
// }
// }
// ```
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
//
// ## References
