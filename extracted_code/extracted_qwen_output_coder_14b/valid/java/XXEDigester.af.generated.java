package com.example.service;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        Digester digester = new Digester();
        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
    }
}