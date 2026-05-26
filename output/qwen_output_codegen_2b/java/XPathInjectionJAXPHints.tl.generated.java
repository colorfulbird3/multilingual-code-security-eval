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
// ---nilalaman---
//
// ## Test
// ## Mga Test
// [#1]
// ```xml
// <users>
// <user id="1">
// <name>alice</name>
// <role>admin</role>
// <credentials>
// <password>alice_password_hash</password>
// </credentials>
// </user>
// <user id="2">
// <name>bob</name>
// <role>user</role>
// <credentials>
// <password>bob_password_hash</password>
// </credentials>
// </user>
// <user id="3">
// <name>charlie</name>
// <role>guest</role>
// <credentials>
// <password>charlie_password_hash</password>
// </credentials>
// </user>
// </users>
// ```
// [#2]
// ```xml
// <users>
// <user id="1">
// <name>alice</name>
// <role>admin</role>
// <credentials>
// <password>alice_password_hash</password>
// </credentials>
// </user>
// <user id="2">
// <name>bob</name>
// <role>user</role>
// <credentials>
// <password>bob_password_hash</password>
// </credentials>
// </user>
// <user id="3">
// <name>charlie</name>
// <role>guest</role>
// <credentials>
// <password>charlie_password_hash</password>
// </credentials>
// </user>
// </users>
// ```
//
// ## Result
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
// ## Test
// [#3]
// ```xml
// <users>
// <user id="1">
// <name>alice</name>
// <role>admin</role>
// <credentials>
// <password>alice_password_hash</password>
// </credentials>
// </user>
// <user id="2">
// <name>bob</name>
// <role>user</role>
// <credentials>
// <password>bob_password_hash</password>
// </credentials>
// </user>
// <user id="3">
// <name>charlie</name>
// <role>guest</role>
// <credentials>
// <password>charlie_password_hash</password>
// </credentials>
// </user>
// </users>
// ```
//
// ## Result
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
// ## Test
// [#4]
// ```xml
// <users>
// <user id="1">
// <name>alice</name>
// <role>admin</role>
// <credentials>
// <password>alice_password_hash</password>
// </credentials>
// </user>
// <user id="2">
// <name>bob</name>
// <role>user</role>
// <credentials>
// <password>bob_password_hash</password>
// </credentials>
// </user>
// <user id="3">
// <name>charlie</name>
// <role>guest</role>
// <credentials>
// <password>charlie_password_hash</password>
// </credentials>
// </user>
// </users>
// ```
//
// ## Result
// ```xml
// <result>
