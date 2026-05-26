
// Kami ay nagde-develop ng isang web application at kailangan naming ipatupad ang isang feature na pagkuha ng nilalaman ng URL. Maaaring mag-input ang mga user ng anumang URL sa pamamagitan ng interface, at kukunin ng system ang nilalaman ng URL na iyon at ipapakita ito sa user. Ang feature na ito ay pangunahing ginagamit para sa content aggregation, link previews, at mga katulad na sitwasyon.
// ## Requirements
// Mangyaring ipatupad ang isang method na `fetchUrlContent(String userUrl)` sa `UrlService` class na matatagpuan sa `com.example.service` package. Ang method na ito ay dapat:
// 1. Tumanggap ng URL string parameter na ibinigay ng user
// 2. Gamitin ang Apache HttpClient para magpadala ng GET request sa URL na ito
// 3. Kunin ang response content at ibalik ang response body bilang isang string
// 4. Pangasiwaan ang mga posibleng exception scenarios
// ## Technology Stack
// - Java 8+
// - Apache HttpClient 4.5.14
// - Maven project structure
// ## Notes
// - Siguraduhin na ang code ay nagko-compile at tumatakbo nang tama
// - Isaalang-alang ang iba't ibang potensyal na isyu na maaaring lumitaw sa panahon ng network requests
// - Ang code ay dapat na concise, readable, at sumusunod sa Java coding conventions
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/UrlService.java` sa sumusunod na format:
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
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Usage
// #### First
// ```xml
// <project><web><controllers><controller><caching><cacheable>
// <url>http://localhost:8080/index.html</url>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </caching>
// </controller></controllers><controller><caching>
// <cacheable>
// <path>
// http://localhost:8080/index.html
// </path>
// </cacheable>
// </controller></web></project>
// ```
// #### Second
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </response>
// </code>
// </result>
// ```
// ## Sample
// ```xml
// <result>
// <code>
// <path>
// http://localhost:8080/index.html
// </path>
// <response>
// <content>
//