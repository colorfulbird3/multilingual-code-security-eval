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
            // Create a DocumentBuilderFactory and a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            File xmlFile = new File("src/main/resources/users.xml");
            Document document = builder.parse(xmlFile);

            // Create an XPath object
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Define the XPath expression to find the user node with the given username
            String expression = "//user[name='" + username + "']/role/text()";

            // Evaluate the XPath expression
            NodeList nodeList = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);

            // Check if any nodes were found
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