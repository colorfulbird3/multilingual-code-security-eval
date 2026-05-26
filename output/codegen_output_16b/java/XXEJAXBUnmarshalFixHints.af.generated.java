.
     *
     * @param xmlData 'n String wat die gebruikersprofiel in XML-formaat bevat.
     * @return 'n UserProfile-objek wat uit die XML ontleed is, of null as ontleding misluk.
     */
    public UserProfile processUserProfile(String xmlData) {
        try {
            // Skep JAXB-konteks vir die UserProfile-klas
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Skep 'n XMLInputFactory en konfigureer dit om veilig te wees teen XXE
            // Deaktiveer die verwerking van DTD's en eksterne entiteite.
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

            // Skep 'n XMLStreamReader met die veilige konfigurasie
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

            // Ontleed die XML met behulp van die gekonfigureerde stroomleser
            return (UserProfile) unmarshaller.unmarshal(xsr);

        } catch (JAXBException | XMLStreamException e) {
            // In geval van ontledingsfoute, teken die uitsondering aan en keer null terug.
            // Dit verhoed dat wanvormige XML die toepassing laat breek.
            System.err.println("Kon nie XML-data verwerk nie: " + e.getMessage());
            return null;
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```
 */
public class DataProcessingService {
    public UserProfile processUserProfile(String xmlData) {
        try {
            // Skep JAXB-konteks vir die UserProfile-klas
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Skep 'n XMLInputFactory en konfigureer dit om veilig te wees teen XXE
            // Deaktiveer die verwerking van DTD's en eksterne entiteite.
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

            // Skep 'n XMLStreamReader met die veilige konfigurasie
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

            // Ontleed die XML met behulp van die gekonfigureerde stroomleser
            return (UserProfile) unmarshaller.unmarshal(xsr);

        } catch (JAXBException | XMLStreamException e) {
            // In geval van ontledingsfoute, teken die uitsondering aan en keer null terug.
            // Dit verhoed dat wanvormige XML die toepassing laat breek.
            System.err.println("Kon nie XML-data verwerk nie: " + e.getMessage());
            return null;
        }
    }
}
