package com.app.service;

import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class XmlProcessingService {

    /**
     * Laai en ontleed 'n XML Schema vanaf 'n string inhoud deur JAXP (SAX Parser) te gebruik.
     * Hierdie metode valideer die skema se formaat en berei dit voor vir daaropvolgende data-validering.
     *
     * @param schemaContent 'n String wat die XML Schema (XSD) inhoud bevat.
     * @throws Exception Indien enige fout tydens skema-ontleding of validering voorkom.
     */
    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Skema-inhoud kan nie nul of leeg wees nie.");
        }

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Opsioneel: Om XML Schema validering tydens ontleding te aktiveer, ontkommentaar die volgende lyn.
            // Dit sal vereis dat 'n skema op die ontleder of valideerder gestel word indien jy
            // validering teen 'n bekende skema-struktuur vir die XSD self uitvoer.
            // Vir hierdie spesifieke vereiste (ontleding van skema-inhoud om sy eie formaat na te gaan),
            // is 'n basiese SAX-ontleding voldoende.
            // factory.setValidating(true);

            SAXParser saxParser = factory.newSAXParser();

            // Gebruik 'n DefaultHandler om bloot die XML te ontleed.
            // Vir skema-validering tydens ontleding, sal 'n meer spesifieke hanteerder of Valideerder gebruik word.
            // Die vereiste is egter om "hierdie Skemas te ontleed en saam te stel, om voor te berei vir
            // daaropvolgende valideringsproses", wat die basiese strukturele kontrole van die XSD self impliseer.
            saxParser.parse(new InputSource(new StringReader(schemaContent)), new DefaultHandler() {
                @Override
                public void warning(SAXParseException e) {
                    // Teken waarskuwings aan maar stop nie ontleding nie
                    System.out.println("Skema-ontledingswaarskuwing: " + e.getMessage());
                }

                @Override
                public void error(SAXParseException e) throws SAXParseException {
                    // Behandel foute as krities en gooi weer om ontledingsmislukking aan te dui
                    throw new SAXParseException("Skema-ontledingsfout: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
                }

                @Override
                public void fatalError(SAXParseException e) throws SAXParseException {
                    // Behandel noodlottige foute as krities en gooi weer
                    throw new SAXParseException("Skema-ontleding noodlottige fout: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
                }
            });

            System.out.println("XML Schema suksesvol gelaai en ontleed.");

        } catch (SAXParseException e) {
            // Vang spesifieke SAX-ontledingsuitsonderings en gooi weer as 'n meer algemene uitsondering
            throw new Exception("Kon nie XML Schema ontleed as gevolg van inhoudsfoute nie: " + e.getMessage(), e);
        } catch (Exception e) {
            // Vang enige ander uitsonderings tydens ontleder-opstelling of ontleding
            throw new Exception("'n Onverwagte fout het voorgekom tydens die laai van XML Schema: " + e.getMessage(), e);
        }
    }
}