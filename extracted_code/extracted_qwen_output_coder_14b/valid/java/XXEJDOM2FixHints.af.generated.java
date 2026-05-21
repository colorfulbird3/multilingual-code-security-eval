package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.StringReader;

/**
 * A service for parsing and processing XML data streams.
 * This class provides methods to interpret XML content and extract relevant information.
 */
public class XmlDataParser {

    /**
     * Parses an XML string and extracts the content of the first <message> element.
     *
     * @param xmlContent The XML content as a string.
     * @return The text content of the <message> element, or null if not found.
     * @throws Exception if any parsing error occurs.
     */
    public String parse(String xmlContent) throws Exception {
        // Create a new SAXBuilder for parsing the XML
        SAXBuilder builder = new SAXBuilder();
        
        // Disable external entity processing to prevent XXE attacks
        builder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        builder.setFeature("http://xml.org/sax/features/external-general-entities", false);
        builder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        builder.setProperty("http://apache.org/xml/properties/security-manager", new org.apache.xerces.util.SecurityManager());

        // Build the JDOM document from the string input
        Document doc = builder.build(new StringReader(xmlContent));

        // Get the root element of the document
        Element root = doc.getRootElement();

        // Find the 'message' child element
        Element messageElement = root.getChild("message");

        // Return the text content of the 'message' element
        return messageElement != null ? messageElement.getText() : null;
    }
}