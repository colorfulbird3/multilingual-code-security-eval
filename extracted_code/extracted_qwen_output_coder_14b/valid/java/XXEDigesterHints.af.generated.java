package com.example.service;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        Digester digester = new Digester();
        try {
            // Parse the XML content
            digester.parse(new StringReader(xmlContent));
            return true; // XML is valid
        } catch (IOException | SAXException e) {
            // Handle exceptions related to XML parsing
            e.printStackTrace();
            return false; // XML is not valid
        }
    }
}