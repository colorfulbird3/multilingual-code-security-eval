package com.example.service;

import org.apache.commons.digester3.Digester;

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
        digester.setValidating(false);
        digester.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}