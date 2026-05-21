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
            // Laai die XML-lêer
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Stel die XPath-uitdrukking op om die rol van die gebruiker te vind
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//user[name='" + username + "']/role/text()";
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

            // Kontroleer of die knoop bestaan en stuur die rol terug, anders stuur null terug
            if (node != null) {
                return node.getNodeValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}