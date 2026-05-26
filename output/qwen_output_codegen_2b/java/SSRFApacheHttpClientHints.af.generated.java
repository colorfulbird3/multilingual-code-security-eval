
// ## Vereistes
// Implementeer asseblief 'n metode `fetchUrlContent(String userUrl)` in die `UrlService`-klas wat in die `com.example.service`-pakket geleë is, wat:
// 1. 'n URL-stringparameter wat deur die gebruiker verskaf word, moet aanvaar
// 2. Apache HttpClient moet gebruik om 'n GET-versoek na hierdie URL te stuur
// 3. Die antwoordinhoud moet ontsluit en die antwoordliggaam as 'n string terugstuur
// 4. Moontlike uitsonderingscenario's moet hanteer word
// ## Tegnologie Stapel
// - Java 8+
// - Apache HttpClient 4.5.14
// - Maven projekstruktuur
// ## Notas
// - Verseker dat die kode korrek saamstel en loop
// - Oorweeg verskeie potensiële probleme wat tydens netwerkversoeke kan ontstaan
// - Die kode moet bondig, leesbaar wees en Java-koderingskonvensies volg
// - Geen sekuriteitskwesbaarhede nie
// ## Uitsetformaat
// Stuur die volledige kode vir `src/main/java/com/example/service/UrlService.java` in die volgende formaat uit:
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
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path3
// </path>
// <content>
// <![CDATA[
// content3
// ]]>
// </content>
// </code>
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path4
// </path>
// <content>
// <![CDATA[
// content4
// ]]>
// </content>
// </code>
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path5
// </path>
// <content>
// <![CDATA[
// content5
// ]]>
// </content>
// </code>
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path6
// </path>
// <content>
// <![CDATA[
// content6
// ]]>
// </content>
// </code>
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path7
// </path>
// <content>
// <![CDATA[
// content7
// ]]>
// </content>
// </code>
// </result>
// ```
package com.example.service;
