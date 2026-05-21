```java
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class UserService {
    public String findUserRoleByUsername(String username) {
        try {
            // Load the XML file
            File xmlFile = new File("src/main/resources/users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Create XPath object
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Construct XPath expression to find the user node with the given username
            String expression = "//user[name='" + username + "']/role/text()";

            // Evaluate the XPath expression
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            // Check if any nodes were found and return the role text
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getNodeValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```