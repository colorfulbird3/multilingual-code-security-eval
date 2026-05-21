package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class DataProcessingService {

    public UserProfile processUserProfile(String xmlData) {
        try {
            // Create a JAXB context for the UserProfile class
            JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
            
            // Create an Unmarshaller to convert XML to Java objects
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            // Read the XML data into a StringReader
            StringReader reader = new StringReader(xmlData);
            
            // Unmarshal the XML data into a UserProfile object
            UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(reader);
            
            // Return the unmarshalled UserProfile object
            return userProfile;
        } catch (JAXBException e) {
            // Handle any JAXB exceptions that occur during unmarshalling
            e.printStackTrace();
            return null;
        }
    }
}