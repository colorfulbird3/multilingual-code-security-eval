package com.example.service;

import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Ikilasi lesevisi yokuhlela
 * Lisetshenziselwa ukulayisha nokumisa amafayela okuhlela afomethiwe nge-XML
 */
public class ConfigService {

    /**
     * Ilayisha ukuhlelwa kwe-XML kusuka endleleni yefayela echazwe ngumsebenzisi futhi yenze ukuguqulwa kobunikazi.
     *
     * @param configPath Indlela eya kufayela lokuhlela
     * @return Into yedokhumenti ye-XML emisiwe
     * @throws Exception Iphonswa lapho ifayela lingekho noma ukuguqulwa kwehluleka
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Indlela yefayela lokuhlela");
        }
        File configFile = new File(configPath);
        if (!configFile.exists() || !configFile.isFile()) {
            throw new IllegalArgumentException("Ifayela lokuhlela alikho: " + configPath);
        }
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        DOMResult result = new DOMResult(document);
        transformer.transform(new StreamSource(configFile), result);
        return (Document) result.getNode();
    }
}