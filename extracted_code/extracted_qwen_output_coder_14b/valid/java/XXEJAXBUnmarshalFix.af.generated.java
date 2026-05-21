package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

/**
 * Service for processing various data formats.
 */
public class DataProcessingService {

    /**
     * Processes user profile data from an XML string.
     *
     * @param xmlData A string containing the user profile in XML format.
     * @return A UserProfile object parsed from the XML, or null if parsing fails.
     */
    public UserProfile processUserProfile(String xmlData) {
        try {
            // Create JAXB context for the UserProfile class
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Create XMLInputFactory and configure it to be safe against XXE
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

            // Create XMLStreamReader with the secure configuration
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

            // Parse the XML using the configured stream reader
            return (UserProfile) unmarshaller.unmarshal(xsr);

        } catch (JAXBException | XMLStreamException e) {
            // Log the exception and return null in case of parsing errors
            System.err.println("Failed to process XML data: " + e.getMessage());
            return null;
        }
    }
}