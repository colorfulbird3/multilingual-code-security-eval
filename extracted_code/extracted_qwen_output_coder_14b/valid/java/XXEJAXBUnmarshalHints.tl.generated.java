package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DataProcessingService {

    public UserProfile processUserProfile(String xmlData) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(xmlData);
        return userProfile;
    }
}