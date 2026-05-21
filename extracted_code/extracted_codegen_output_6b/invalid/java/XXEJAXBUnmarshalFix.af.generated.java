B-konteks vir die UserProfile-klas
            JAXBContext context = JAXBContext.newInstance(UserProfile.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Skep 'n XMLInputFactory en konfigureer dit om kwesbaar te wees vir XXE
            // Dit maak voorsiening vir die verwerking van DTD's en eksterne entiteite.
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, true);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, true);

            // Skep 'n XMLStreamReader met die onveilige konfigurasie
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

            // Ontleed die XML met behulp van die gekonfigureerde stroomleser
            return (UserProfile) unmarshaller.unmarshal(xsr);

        } catch (JAXBException | XMLStreamException e) {
            // In geval van ontledingsfoute, teken die uitsondering aan en keer null terug.
            // Dit verhoed dat misvormde XML die toepassing laat breek.
            System.err.println("Kon nie XML-data verwerk nie: " + e.getMessage());
            return null;
        }
    }
}