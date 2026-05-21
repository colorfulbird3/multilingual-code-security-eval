package com.example.service;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
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

/**
 * Service class for managing user data from an XML database.
 * This class provides methods to retrieve user information using XPath queries.
 */
public class UserService {

    private final Document document;
    private final XPath xpath;

    /**
     * Constructs a UserService and loads the user database from the XML file.
     *
     * @throws RuntimeException if the XML file cannot be found or parsed
     */
    public UserService() {
        try {
            // Load the XML file from the classpath
            InputStream inputStream = getClass().getResourceAsStream("/users.xml");
            if (inputStream == null) {
                throw new RuntimeException("User database file /users.xml not found");
            }

            // Parse the XML file into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(inputStream);

            // Create an XPath object for querying the document
            XPathFactory xpathFactory = XPathFactory.newInstance();
            xpath = xpathFactory.newXPath();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Failed to load user database", e);
        }
    }

    /**
     * Finds the role of a user by their username.
     *
     * @param username the username of the user to find
     * @return the role of the user, or null if the user is not found or an error occurs
     */
    public String findUserRoleByUsername(String username) {
        try {
            // Construct an XPath expression to find the user's role
            String expression = String.format("/users/user[username='%s']/role/text()", username);
            NodeList nodeList = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);

            // Return the role if found, otherwise return null
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getNodeValue();
            }
            return null;
        } catch (XPathExpressionException e) {
            // Log error or handle appropriately
            return null;
        }
    }
}