```java
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class UserService {
    private static final String USERS_DB_PATH = "users.xml";
    private final Document xmlDocument;
    private final XPath path;

    public UserService() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            xmlDocument = builder.parse(USERS_DB_PATH);
            path = XPathFactory.newInstance().newXPath();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load user database", e);
        }
    }

    public String findUserRoleByUsername(String username) {
        try {
            String expression = "//user[username=$username]/role/text()";
            path.setXPathVariableResolver(v -> {
                if ("username".equals(v.getLocalPart())) {
                    return username;
                }
                return null;
            });
            return (String) path.evaluate(expression, xmlDocument, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            return null;
        }
    }
}
```