package com.example.service;

import org.apache.commons.digester3.Digester;

import java.io.StringReader;

public class ConfigLoaderService {

    /**
     * Valideer of die XML-inhoud welgevormd is.
     *
     * @param xmlContent Die XML-string wat gevalideer moet word.
     * @return true as die XML-inhoud geldig is; andersins false.
     */
    public boolean load(String xmlContent) {
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            return false;
        }

        Digester digester = new Digester();
        digester.setValidating(false); // Set validation to false since we only need format validation

        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            // Log the exception for debugging purposes (optional)
            System.err.println("XML validation failed: " + e.getMessage());
            return false;
        }
    }
}