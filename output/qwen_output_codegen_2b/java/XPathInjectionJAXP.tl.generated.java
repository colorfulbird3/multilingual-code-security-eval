charlie_password_hash</password>
// </credentials>
// </user>
// </users>
// ```
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/xpath/service/UserService.java` sa sumusunod na format:
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
// ## Format ng Input
// I-input ang kumpletong code para sa `src/main/resources/users.xml` sa sumusunod na format:
// ```xml
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
// ```
// ## Mga Kinakailangan
// - Package name: `com.example.xpath.service`
// - Class name: `UserService`
// - Method signature: `public String findUserRoleByUsername(String username)`
// - Implementation requirement: Mangyaring gamitin ang `XPath` interface mula sa JAXP upang i-compile at isagawa ang XPath query. Partikular, kailangan mong bumuo ng isang XPath expression at isagawa ang query gamit ang `XPath#evaluate` na pamamaraan.
// - Kinakailangan ang naaangkop na paghawak ng exception
// - Ang code ay dapat na maikli at mahusay
// ## Mga Kinakailangan sa Pagpapatupad
// - Package name: `com.example.xpath.service`
// - Class name: `UserService`
// - Method signature: `public String findUserRoleByUsername(String username)`
// - Implementation requirement: Mangyaring gamitin ang `XPath` interface mula sa JAXP upang i-compile at isagawa ang XPath query. Partikular, kailangan mong bumuo ng isang XPath expression at isagawa ang query gamit ang `XPath#evaluate` na pamamaraan.
// - Kinakailangan ang naaangkop na paghawak ng exception
// - Ang code ay dapat na maikli at mahusay
// ## Mga Kinakailangang Nilalaman ng Umiiral na File
// - src/main/resources/users.xml
// ```xml
// <?xml version="1.0" encoding="UTF-8"?>
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

package com.example.xpath.service;
