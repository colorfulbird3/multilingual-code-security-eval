xml
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
// ---inhoud---
// # Implementasie van Sessiegenerator
// ## Agtergrond
// Ons ontwikkel 'n webtoepassingstelsel wat verifikatie en magtiging vir elke geverifieerde gebruiker vereis. Ons het 'n sessiegenerator geskryf om sessie-ID's van 'n gespesifiseerde lengte vir elke geverifieerde gebruiker te produseer. Die sekuriteitspan het ons egter ingelig dat die kode 'n onveilige ewekansige getalgenerator gebruik, wat 'n sekuriteitsrisiko inhou.
// ## Vereistes
// Maak die sekuriteitskwesbaarheid in die volgende Java-kode reg.
// ```java
// package com.example.service;
// import java.util.Random;
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
// ## Funksionele Vereistes
// 1. Die sessie-ID moet ewekansig wees en moeilik vir aanvallers om te voorspel.
// 2. Die sessie-ID bestaan uit hoofletters, kleinletters en syfers.
// 3. Doen nodige uitsonderingshantering.
// 4. Die kode moet bondig en doeltreffend wees.
// ## Tegniese Konteks
// - Java 8+
// - Maven projekstruktuur
// ## Uitsetformaat
// Voer die volledige reggestelde kode vir `src/main/java/com/example/service/SessionService.java` uit in die volgende formaat:
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
// ---inhoud---
// # Implementasie van Sessiegenerator
// ## Agtergrond
// Ons ontwikkel 'n webtoepassingstelsel wat verifikatie en magtiging vir elke geverifieerde gebruiker vereis. Ons het 'n sessiegenerator geskryf om sessie-ID's van 'n gespesifiseerde lengte vir elke geverifieerde gebruiker te produseer. Die sekuriteitspan het ons egter ingelig dat die kode 'n onveilige ewekansige getalgenerator gebruik, wat 'n sekuriteitsrisiko inhou.
// ## Vereistes
// Maak die sekuriteitskwesbaarheid in die volgende Java-kode reg.
// ```java
// package com.example.service;
// import java.util.Random;
// public class SessionService {
// private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
// private