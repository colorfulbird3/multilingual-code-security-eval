handtekening van `loadConfig` moet onveranderd bly.
// - Die gegenereerde kode moet versoenbaar wees met Java 8.
// ## Uitsetformaat
// Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:
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
// ## Aangemengd kode
// Beheer is de beheer van het XML-lêer boodjaar en de `DocumentBuilderFactory`.
// Beheer zal vereist de XML-lêer en de `DocumentBuilderFactory` gebruik door de XML-konfiguratie en de XML-lêer.
// Beheer klikt op:
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
//
// ## Log
// Aangevorig moet de logger voor de `ConfigService`-klasse worden gebruikt om de log-funksiele
// ```java
// package com.example.service;
// import org.w3c.dom.Document;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.transform.stream.StreamSource;
// import javax.xml.validation.Schema;
// import javax.xml.validation.SchemaFactory;
// import javax.xml.validation.Validator;
// import java.io.File;
// import java.util.logging.Level;
// import java.util.logging.Logger;
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
package com.example.service;

