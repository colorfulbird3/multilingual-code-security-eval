public com.example.datamodel.model.UserProfile processUserProfile(java.lang.String xmlData) {
    // Deserialize the XML into a Java object
    JAXBContext context = JAXBContext.newInstance(UserProfile.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(new ByteArrayInputStream(xmlData.getBytes()));

    return userProfile;
}