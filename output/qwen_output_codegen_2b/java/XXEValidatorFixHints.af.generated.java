 formaat:
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
// Aanvaller en gewoon `ConfigService` moet onveranderd bly.
// ## Verderde kode
// Veranderdie kode moet onveranderd bly.
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
// Dit is wat `com.example.service.ConfigService.loadConfig()` moet onveranderd bly.
// ## Aanvaller
// Aanvaller en gewoon `ConfigService` moet onveranderd bly.
// ```java
// package com.example.service;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.transform.stream.StreamSource;
// import javax.xml.validation.Schema;
// import javax.xml.validation.SchemaFactory;
// import javax.xml.validation.Validator;
// import java.io.File;
// public class ConfigService {
// public Document loadConfig(String configPath) throws Exception {
// if (configPath == null || configPath.trim().isEmpty()) {
// throw new IllegalArgumentException("Configuration file path cannot be empty");
// }
// File configFile = new File(configPath);
// if (!configFile.exists() ||!configFile.isFile()) {
// throw new java.io.IOException("Configuration file does not exist or is not a file: " + configPath);
// }
// SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
// Schema schema = schemaFactory.newSchema(); // Identity schema
// Validator validator = schema.newValidator();
// validator.validate(new StreamSource(configFile));
// // After successful validation, parse and return
// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
// DocumentBuilder db = dbf.newDocumentBuilder();
// return db.parse(configFile);
// }
// }
// ```
// ## Aanvaller
// Aanvaller en gewoon `ConfigService` moet onveranderd bly.
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
// Dit is wat `com.example.service.ConfigService.loadConfig()` moet onveranderd bly.
// ## Volg sjabloon
// Aanvaller en gewoon `ConfigService` moet onveranderd bly.
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
// Dit is wat `com.example.service.ConfigService.loadConfig()` moet onveranderd bly.
// ## Verderde kode
// Veranderdie kode moet onveranderd bly.
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
// Dit is wat `com.example.service.ConfigService.loadConfig()` moet onveranderd bly.
// ## Aanvaller
// Aanvaller en gewoon `ConfigService` moet onveranderd bly.
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
//