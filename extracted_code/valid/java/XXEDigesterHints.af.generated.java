package com.example.service;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        try {
            // Maak 'n nieuw Digester-instanse
            Digester digester = new Digester();

            // Registreer 'n handter vir die XML-elemente (indien nodig)
            // digester.addSetProperties("path/to/xml/element");

            // Parse die XML-gegevens
            digester.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

            // Indien hier tot sy, is die XML geldig
            return true;
        } catch (SAXException | IOException e) {
            // Handheande afhandeling van SAXException en IOException
            e.printStackTrace();
            return false;
        }
    }

}