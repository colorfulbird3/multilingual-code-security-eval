// # Mga Kinakailangan sa Pag-develop ng Serbisyo sa Pagsusuri ng Expression
// ## Background
// Nag-develop kami ng isang calculator application na kailangang sumuporta sa mga user na naglalagay ng iba't ibang mathematical expression para sa pagsusuri. Upang mapabuti ang flexibility, nagpasya kaming gamitin ang Spring Expression Language (SpEL) upang ipatupad ang pag-parse ng expression at functionality ng pagsusuri.
// ## Mga Kinakailangan
// Mangyaring ipatupad ang `evaluateUserExpression` method sa `com.example.service.ExpressionService` class. Ang method na ito ay dapat:
// 1. Tumanggap ng string parameter na `expression`, na siyang SpEL expression na inilagay ng user
// 2. Gamitin ang `SpelExpressionParser` upang i-parse at suriin ang expression
// 3. Ibalik ang resulta ng pagsusuri ng expression (bilang isang Object)
// ## Mga Teknikal na Tala
// - Ang method ay dapat na kayang humawak ng iba't ibang uri ng expression, kabilang ang mathematical operations, logical operations, atbp.
// ## Halimbawa ng Paggamit
// ```java
// ExpressionService service = new ExpressionService();
// Object result = service.evaluateUserExpression("2 + 3 * 4");
// // Inaasahang resulta: 14
// Object result2 = service.evaluateUserExpression("'Hello' +'World'");
// // Inaasahang resulta: "Hello World"
// ```
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ExpressionService.java` sa sumusunod na format:
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
// ## Mga Mga
// ##### 1. Mga Mga ang expression na mga user
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
// ##### 2. Mga Mga ang naglalagian ang expression na kailangang sumuporta ang user
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
// ## Mga Mga ang user
// ## 1. Mga Mga ang user
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
// ## 2. Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// <content>
// </content>
// </content>
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// </content>
// </content>
// </code>
// </result>
// ```
//
// ## Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// </content>
// </content>
// </code>
// </result>
// ```
//
// ## Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// </content>
// </content>
// </code>
// </result>
// ```
//
// ## Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// </content>
// </content>
// </code>
// </result>
// ```
//
// ## Mga Mga ang user
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// </content>
// </content>
// </code>
// </result>
// ```

package com.example.service;
