package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class DataProcessingService {
    public UserProfile processUserProfile(String xmlData) {
        if (xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("XML data cannot be null or empty");
        }
        try {
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlData);
            return (UserProfile) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new IllegalArgumentException("Error parsing XML data: " + e.getMessage(), e);
        }
    }
}