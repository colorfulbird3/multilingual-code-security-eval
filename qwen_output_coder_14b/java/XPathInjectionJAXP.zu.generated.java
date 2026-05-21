Here is a possible implementation of the `UserService` class with the `findUserRoleByUsername` method using JAXP and XPath:

```java
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Load the XML document
            File xmlFile = new File("src/main/resources/users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Create XPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();

            // XPath query to find user role by username
            String expression = "//user[name='" + username + "']/role";
            Element roleElement = (Element) xPath.evaluate(expression, doc, XPathConstants.NODE);

            if (roleElement != null) {
                return roleElement.getTextContent();
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

This implementation does the following:
1. Loads the `users.xml` file into a `Document` object.
2. Creates an `XPath` instance.
3. Defines an XPath expression to find the `role` element for a given `username`.
4. Evaluates the XPath expression on the document.
5. Returns the text content of the `role` element if found, otherwise returns `null`.

This should meet the requirements specified in the task description.