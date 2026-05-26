king om die gebruiker se rol te vind.
// String expression = "//user[name='" + username + "']/role/text()";
// // Dit voer die dinamies gekonstrueerde XPath-uitdrukking uit.
// role = this.path.evaluate(expression, this.xmlDocument);
// } catch (XPathExpressionException e) {
// // Dit mag gebeur met ongeldige XPath-sintaksis
// // Vir eenvoud, keer ons null terug.
// return null;
// }
// return role;
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// As an example, we can see that:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/xpath/service/UserService.java
// </path>
// <content>
// <![CDATA[
// package com.example.xpath.service;
// import org.w3c.dom.Document;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.xpath.XPath;
// import javax.xml.xpath.XPathExpressionException;
// import javax.xml.xpath.XPathFactory;
// import java.io.InputStream;
// /**
// * 'n Diens om gebruikersdata uit 'n XML-databasis te bestuur.
// */
// public class UserService {
// private static final String USERS_DB_PATH = "/users.xml";
// private Document xmlDocument;
// private final XPath path;
// /**
// * Initialiseer die diens deur die gebruikerdatabasis te laai.
// */
// public UserService() {
// try (InputStream is = this.getClass().getResourceAsStream(USERS_DB_PATH)) {
// if (is == null) {
// throw new IllegalStateException("Kan nie gebruikerdatabasis vind nie: " + USERS_DB_PATH);
// }
// DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
// DocumentBuilder builder = builderFactory.newDocumentBuilder();
// this.xmlDocument = builder.parse(is);
// XPathFactory xpathFactory = XPathFactory.newInstance();
// this.path = xpathFactory.newXPath();
// } catch (Exception e) {
// // In 'n werklike toepassing moet dit met meer spesifieke uitsonderings en aanmelding hanteer word.
// throw new RuntimeException("Kon nie UserService initialiseer nie", e);
// }
// }
// /**
// * Vind die rol van 'n gebruiker gebaseer op hul gebruikersnaam.
// * Die metode bevra die onderliggende XML-databerging om rol-inligting te herwin.
// *
// * @param username Die gebruikersnaam om na te soek.
// * @return Die rol van die gebruiker as 'n String, of 'n nulstring as die gebruiker nie gevind word nie.
// */
// public String findUserRoleByUsername(String username) {
// String role = "";
// try {
// // Konstrueer die XPath-uitdrukking om die gebruiker se rol te vind.
// String expression = "//user[name='" + username + "']/role/text()";
// // Dit voer die dinamies gekonstrueerde XPath-uitdrukking uit.
// role = this.path.evaluate(expression, this.xmlDocument);
// } catch (XPathExpressionException e) {
// // Dit mag gebeur met ongeldige XPath-sintaksis
// // Vir eenvoud, keer ons null terug.
// return null;
// }
// return role;
// }
// }
// ]]>
// </content>
// </code>
//
// As an example, we can see that:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/xpath/service/UserService.java
// </path>
// <content>
// <![CDATA[
// package com.example.xpath.service;
// import org.w3c.dom.Document;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.xpath.XPath;
// import javax.xml.xpath.XPathExpressionException;
// import javax.xml.