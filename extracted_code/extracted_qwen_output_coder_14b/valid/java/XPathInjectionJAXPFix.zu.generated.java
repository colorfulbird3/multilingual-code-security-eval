package com.example.xpath.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * Inkonzo yokuphatha idatha yomsebenzisi evela kusizindalwazi se-XML.
 */
public class UserService {

    private static final String USERS_DB_PATH = "/users.xml";
    private Document xmlDocument;
    private final XPath path;

    /**
     * Iqala inkonzo ngokulayisha isizindalwazi somsebenzisi.
     */
    public UserService() {
        try (InputStream is = this.getClass().getResourceAsStream(USERS_DB_PATH)) {
            if (is == null) {
                throw new IllegalStateException("Ayitholakali ifayela lesizindalwazi somsebenzisi: " + USERS_DB_PATH);
            }
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.xmlDocument = builder.parse(is);

            XPathFactory xpathFactory = XPathFactory.newInstance();
            this.path = xpathFactory.newXPath();
        } catch (Exception e) {
            throw new RuntimeException("Uhlulekile ukuqalisa i-UserService", e);
        }
    }

    /**
     * Ithola indima yomsebenzisi ngokusekelwe egameni lakhe lomsebenzisi.
     * Indlela ibuza isitolo sedatha se-XML ukuze ithole ulwazi lwendima.
     *
     * @param username Igama lomsebenzisi okufanele liseshwe.
     * @return Indima yomsebenzisi njenge-String, noma i-null uma umsebenzisi engatholakali.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            String expression = "//user[name='" + username + "']/role/text()";
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            return null;
        }
        return role;
    }
}