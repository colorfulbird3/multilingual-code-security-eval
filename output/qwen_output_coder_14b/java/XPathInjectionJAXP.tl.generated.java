```xml
<result>
    <code>
        <path>
            src/main/java/com/example/xpath/service/UserService.java
        </path>
        <content>
            <![CDATA[
package com.example.xpath.service;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Load the XML document
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Create an XPath instance
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Compile the XPath expression
            String expression = "//user[name='" + username + "']/role/text()";
            XPathExpression expr = xpath.compile(expression);

            // Evaluate the expression and return the result
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                return nodes.item(0).getNodeValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```