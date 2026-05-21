package com.example.service;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * 'n Diens vir die verwerking van XML-gebaseerde verslae.
 */
public class ReportService {

    /**
     * Onttrek 'n spesifieke maatstafwaarde uit 'n XML-verslaginhoud deur 'n XPath-uitdrukking te gebruik.
     *
     * @param xmlContent      Die XML-inhoud van die verslag as 'n string.
     * @param xpathExpression Die XPath-uitdrukking om die maatstaf te vind.
     * @return Die stringwaarde van die maatstaf, of null indien 'n fout voorkom of die maatstaf nie gevind word nie.
     */
    public String extractMetric(String xmlContent, String xpathExpression) {
        try {
            // 1. Initialiseer XML-verwerkingsfabrieke
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);

            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Ontleed die XML-inhoud in 'n DOM-dokument
            InputSource is = new InputSource(new StringReader(xmlContent));
            Document doc = builder.parse(is);

            // 3. Skep 'n XPath-voorwerp om uitdrukkings te evalueer
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // 4. Stel die XPath-uitdrukking saam en evalueer dit
            XPathExpression expr = xpath.compile(xpathExpression);
            return (String) expr.evaluate(doc, XPathConstants.STRING);

        } catch (ParserConfigurationException | SAXException | IOException | javax.xml.xpath.XPathExpressionException e) {
            // In geval van enige verwerkingsfout, keer null terug.
            System.err.println("'n Fout het tydens XML-verwerking voorgekom: " + e.getMessage());
            return null;
        }
    }
}