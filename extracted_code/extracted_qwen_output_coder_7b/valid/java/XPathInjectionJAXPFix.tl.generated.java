package com.example.xpath.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * A service to manage user data from an XML database.
 */
public class UserService {

    private static final String USERS_DB_PATH = "/users.xml";
    private Document xmlDocument;
    private final XPath path;

    /**
     * Initializes the service by loading the user database.
     */
    public UserService() {
        try (InputStream is = this.getClass().getResourceAsStream(USERS_DB_PATH)) {
            if (is == null) {
                throw new IllegalStateException("Cannot find user database file: " + USERS_DB_PATH);
            }
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.xmlDocument = builder.parse(is);

            XPathFactory xpathFactory = XPathFactory.newInstance();
            this.path = xpathFactory.newXPath();
        } catch (Exception e) {
            // In a real application, this should be handled with more specific exceptions and logging.
            throw new RuntimeException("Failed to initialize UserService", e);
        }
    }

    /**
     * Finds the role of a user based on their username.
     * The method queries the underlying XML data store to retrieve role information.
     *
     * @param username The username to search for.
     * @return The role of the user as a String, or null string if the user is not found.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            // Construct the XPath expression to find the user's role.
            String expression = "//user[name='" + username + "']/role/text()";

            // It executes the dynamically constructed XPath expression.
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            return null;
        }
        return role;
    }
}