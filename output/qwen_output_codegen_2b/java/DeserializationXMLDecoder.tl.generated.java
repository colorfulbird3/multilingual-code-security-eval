/ConfigurationLoaderService.java` sa sumusunod na format:
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
// ## Test Cases
// ```xml
// <?xml version="1.0" encoding="UTF-8"?>
// <java version="1.0" class="java.beans.XMLDecoder">
// <object class="com.example.config.bean.UserPreferences">
// <void property="username">
// <string>test</string>
// </void>
// <void property="theme">
// <string>dark</string>
// </void>
// <void property="fontSize">
// <int>18</int>
// </void>
// </object>
// </java>
// ```
// ```xml
// <?xml version="1.0" encoding="UTF-8"?>
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
// ## Result
// <pre>
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
// </pre>
// ## Result-XML
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
// ## Result-Java
// ```java
// public class ConfigurationLoaderService {
// private String username;
// private String theme;
// private int fontSize;
//
// public String getUsername() {
// return username;
// }
// public void setUsername(String username) {
// this.username = username;
// }
// public String getTheme() {
// return theme;
// }
// public void setTheme(String theme) {
// this.theme = theme;
// }
// public int getFontSize() {
// return fontSize;
// }
// public void setFontSize(int fontSize) {
// this.fontSize = fontSize;
// }
// }
// ```
package com.example.config.service;
