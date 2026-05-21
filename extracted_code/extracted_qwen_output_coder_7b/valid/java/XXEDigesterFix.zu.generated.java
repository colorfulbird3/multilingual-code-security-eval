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
        // Seta isethi yemithetho engenalutho ngoba sikhathalele ukuba semthethweni kwe-XML kuphela, hhayi ukuhlukanisa kwangempela
        // Uma i-XML ingavumelekile, indlela yokuhlukanisa izophonsa i-SAXException
        digester.setValidating(false); // Ngokuvamile isethwe ibe amanga lapho kuqinisekiswa ifomethi ngaphandle uma kudingeka ukuqinisekiswa kwe-DTD/Schema

        try {
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}