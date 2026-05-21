package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("src/main/resources/users.xml");

            // Normalize the XML structure
            doc.getDocumentElement().normalize();

            // Create an XPath object
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Define the XPath expression to find the user role by username
            String expression = "//user[name='" + username + "']/role/text()";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            // Check if the user is found and return the role
            if (nodeList.getLength() > 0) {
                Node node = nodeList.item(0);
                return node.getNodeValue();
            } else {
                return null; // Return null if no user is found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        String role = userService.findUserRoleByUsername("alice");
        System.out.println("Role for alice: " + role); // Output should be "admin"
    }
}