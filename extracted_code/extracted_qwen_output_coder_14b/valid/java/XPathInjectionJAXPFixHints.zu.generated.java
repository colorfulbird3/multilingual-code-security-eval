```java
package com.example.xpath.service;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

public class UserService {

    private static final String USERS_DB_PATH = "/users.xml";

    private final Document xmlDocument;
    private final XPath path;

    public UserService() {
        try (InputStream inputStream = getClass().getResourceAsStream(USERS_DB_PATH)) {
            if (inputStream == null) {
                throw new IllegalStateException("XML file not found: " + USERS_DB_PATH);
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            xmlDocument = builder.parse(inputStream);

            XPathFactory xpathFactory = XPathFactory.newInstance();
            path = xpathFactory.newXPath();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalStateException("Failed to initialize UserService", e);
        }
    }

    public String findUserRoleByUsername(String username) {
        try {
            String expression = String.format("/users/user[@username='%s']/role/text()", username);
            return (String) path.evaluate(expression, xmlDocument, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            return null;
        }
    }
}
```