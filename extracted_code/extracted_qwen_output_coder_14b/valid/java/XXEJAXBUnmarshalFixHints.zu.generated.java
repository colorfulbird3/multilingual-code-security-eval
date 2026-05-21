package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class DataProcessingService {

    public UserProfile processUserProfile(String xmlData) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

            return (UserProfile) unmarshaller.unmarshal(xsr);

        } catch (JAXBException | XMLStreamException e) {
            System.err.println("Error processing XML data: " + e.getMessage());
            return null;
        }
    }
}