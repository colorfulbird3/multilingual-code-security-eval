package com.example.service;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        try (Digester digester = new Digester()) {
            // Configure the digester rules here
            // For example:
            // digester.addBeanPropertySetter("path", "propertyName");

            // Parse the XML content
            digester.parse(new java.io.StringReader(xmlContent));
            return true; // Return true if parsing is successful
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false; // Return false if parsing fails
        }
    }
}