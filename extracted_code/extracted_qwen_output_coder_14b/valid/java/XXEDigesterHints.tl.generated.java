package com.example.service;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        Digester digester = new Digester();
        digester.setValidating(false);

        try (StringReader reader = new StringReader(xmlContent)) {
            digester.parse(reader);
            return true;
        } catch (IOException | SAXException e) {
            return false;
        }
    }
}