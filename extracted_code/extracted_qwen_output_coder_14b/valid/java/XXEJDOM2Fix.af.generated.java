package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;

import java.io.StringReader;
import java.io.IOException;

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
     * @throws JDOMException if there is an issue with the XML structure.
     * @throws IOException if there is an issue reading the XML content.
     */
    public String parse(String xmlContent) throws JDOMException, IOException {
        // Create a new SAXBuilder for parsing the XML
        SAXBuilder builder = new SAXBuilder();

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