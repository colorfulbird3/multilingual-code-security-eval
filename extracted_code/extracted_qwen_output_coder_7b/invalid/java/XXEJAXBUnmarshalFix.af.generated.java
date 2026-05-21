```java
public UserProfile processUserProfile(String xmlData) {
    try {
        // Create JAXB context for the UserProfile class
        JAXBContext context = JAXBContext.newInstance(UserProfile.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Create an XMLInputFactory and configure it to disable XXE
        XMLInputFactory xif = XMLInputFactory.newInstance();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

        // Create an XMLStreamReader with the secure configuration
        XMLStreamReader reader = xif.createXMLStreamReader(new StringReader(xmlData));
        
        // Unmarshal the XML data into a UserProfile object
        UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(reader);
        
        return userProfile;
    } catch (Exception e) {
        System.err.println("Error processing user profile: " + e.getMessage());
        return null;
    }
}
```