package com.example.service;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.parse(new ByteArrayInputStream(xmlContent.getBytes()));
            return true;
        } catch (IOException | SAXException e) {
            return false;
        }
    }
}