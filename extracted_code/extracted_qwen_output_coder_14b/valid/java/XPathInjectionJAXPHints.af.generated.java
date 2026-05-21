package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.io.InputStream;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Load the XML document from the resource
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Create an XPath instance
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Construct the XPath expression to find the user node with the given username
            String expression = "//user[name='" + username + "']/role/text()";
            String role = (String) xpath.evaluate(expression, document, XPathConstants.STRING);

            return role.isEmpty() ? null : role;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}