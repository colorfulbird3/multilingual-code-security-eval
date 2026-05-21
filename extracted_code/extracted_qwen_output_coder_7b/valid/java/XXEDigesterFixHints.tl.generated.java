package com.example.service;

import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;

public class ConfigLoaderService {

    /**
     * Validates whether the XML content is well-formed.
     *
     * @param xmlContent The XML string to be validated.
     * @return true if the XML content is valid; otherwise, false.
     */
    public boolean load(String xmlContent) {
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            return false;
        }

        Digester digester = new Digester();
        // Set an empty rule set since we only care about XML validity, not actual parsing
        // If the XML is invalid, the parse method will throw a SAXException
        digester.setValidating(false); // Typically set to false when validating format unless DTD/Schema validation is required

        try {
            // Use StringReader to convert the XML string into an input source
            digester.parse(new InputSource(new StringReader(xmlContent)));
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}