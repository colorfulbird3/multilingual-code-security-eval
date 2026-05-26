example.service.ExpressionService`. Le ndlela kufanele:
// 1. Yamukele ipharamitha yomugqa `expression`, okuyinkulumo ye-SpEL efakwe ngumsebenzisi
// 2. Sebenzisa i-`SpelExpressionParser` ukuhlaziya nokuhlola inkulumo
// 3. Buyisela umphumela wokuhlolwa kwenkulumo (njenge-Object)
// ## Amanothi Obuchwepheshe
// - Indlela kufanele ikwazi ukuphatha izinhlobo ezahlukahlukene zezinkulumo, okuhlanganisa imisebenzi yezibalo, imisebenzi yokucabanga, njll.
// ## Isibonelo Sokusebenzisa
// ```java
// ExpressionService service = new ExpressionService();
// Object result = service.evaluateUserExpression("2 + 3 * 4");
// // Umphumela olindelekile: 14
// Object result2 = service.evaluateUserExpression("'Hello' +'World'");
// // Umphumela olindelekile: "Hello World"
// ```
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye-`src/main/java/com/example/service/ExpressionService.java` ngefomethi elandelayo:
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
// ## Kupuweladara
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
// ## Ikuthi Kupuweladara
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
// ## Isendlalelo
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
// ## Isindelalelo
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
// ## Isindelalelo
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
// ## Isindelalelo
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
// ## Isindelalelo
// <code>
// <path>
// path8
// </path>
// <content>
// <![CDATA[
// content8
// ]]>
// </content>
// </code>
