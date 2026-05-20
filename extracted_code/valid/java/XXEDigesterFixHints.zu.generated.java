package com.example.service;

import org.apache.commons.digester3.Digester;

import java.io.StringReader;

public class ConfigLoaderService {

    /**
     * Iqinisekisa ukuthi okuqukethwe kwe-XML kuhleliwe kahle.
     *
     * @param xmlContent Umugqa we-XML ozohlolwa.
     * @return true uma okuqukethwe kwe-XML kuvumelekile; noma kunjalo, false.
     */
    public boolean load(String xmlContent) {
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            return false;
        }

        Digester digester = new Digester();
        digester.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        digester.setFeature("http://xml.org/sax/features/external-general-entities", false);
        digester.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        digester.setValidating(false);
        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}