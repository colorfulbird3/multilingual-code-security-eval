package com.example.service;

import org.apache.commons.digester3.Digester;

import java.io.StringReader;

public class ConfigLoaderService {

    /**
     * Ihlola ukuthi ingqikithi ye-XML yakhiwe kahle yini.
     *
     * @param xmlContent I-XML string okufanele ihlolwe.
     * @return iqiniso uma ingqikithi ye-XML ivumelekile; ngaphandle kwalokho, amanga.
     */
    public boolean load(String xmlContent) {
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            return false;
        }

        Digester digester = new Digester();
        digester.setValidating(false);

        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}