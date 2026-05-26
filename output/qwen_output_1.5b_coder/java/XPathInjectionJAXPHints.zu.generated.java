```java
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UserService {
    public String findUserRoleByUsername(String username) throws IOException, SAXException, XPathExpressionException {
        // Load XML file
        File xmlFile = new File("src/main/resources/users.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // Get the root element
        NodeList users = doc.getElementsByTagName("user");

        // Create an XPath object
        XPath xpath = XPathFactory.newInstance().newXPath();

        for (int i = 0; i < users.getLength(); i++) {
            Node userNode = users.item(i);
            String userName = userNode.getElementsByTagName("name").item(0).getTextContent();
            if (userName.equals(username)) {
                String role = userNode.getElementsByTagName("role").item(0).getTextContent();
                return role;
            }
        }

        return null;
    }
}
```

This Java code defines a `UserService` class with a method `findUserRoleByUsername` that takes a username as input and returns the corresponding role from the XML file using JAXP and XPath. The XML file is loaded, and then a `Document` object is parsed to retrieve all `<user>` elements. For each user, it checks if the name matches the provided username. If a match is found, the role associated with that user is returned. If no match is found, `null` is returned.