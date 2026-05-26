
// ## Teknikal na Konteksto
// - Java 8+
// - Maven project structure
// ## Format ng Output
// I-output ang kumpletong naayos na code para sa `src/main/java/com/example/service/HashService.java` sa sumusunod na format:
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
// <br/>
//
// ## Sample Code
//
// ```java
// package com.example.service;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
// import com.example.model.File;
// import com.example.model.FileList;
// import com.example.model.FileList.File;
// import javax.xml.bind.annotation.XmlRootElement;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters.HashNumeric;
// import org.apache.commons.text.StringEscapeUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
//
// @Service
// public class HashService {
// private static final String ALGORITHM = "MD5";
// private static final String HASH_SEPARATOR = "|";
// private static final String HASH_DIGEST = "=";
//
// @Autowired
// private MessageDigest md;
//
// public String digest(File file) {
// try {
// byte[] bytes = file.read();
// return digest(bytes);
// } catch (Exception e) {
// throw new RuntimeException(e);
// }
// }
//
// public String digest(byte[] data) {
// try {
// return hex(md.digest(data));
// } catch (NoSuchAlgorithmException e) {
// throw new RuntimeException("Hash algorithm not supported: " + ALGORITHM, e);
// }
// }
//
// private String hex(byte[] hashBytes) {
// return StringEscapeUtils.escapeJava(bytesToHex(hashBytes));
// }
//
// private byte[] bytesToHex(byte[] bytes) {
// return bytesToHex(bytes, 0, bytes.length);
// }
//
// private byte[] bytesToHex(byte[] bytes, int offset, int length) {
// StringBuilder sb = new StringBuilder(2 * bytes.length);
// for (byte b : bytes) {
// sb.append(String.format("%02x", b));
// }
// return sb.toString().getBytes();
// }
// }
// ```
// ## References
// * [https://stackoverflow.com/a/32284700] Formatting a string with hexadecimal
// string
// * [https://stackoverflow.com/a/32284700] Java8+
// * [https://stackoverflow.com/a/32284700] Maven project structure
// * [https://stackoverflow.com/a/32284700] Java8+
// * [https://stackoverflow.com/a/32284700] Maven project structure
// * [https://stackoverflow.com/a/32284700] Java8+
// * [https://stackoverflow.com/a/32284700] Maven project structure
// * [https://stackoverflow.com/a/32284700] Java8+
// * [https://stackoverflow.com/a/32284700] Maven project structure
