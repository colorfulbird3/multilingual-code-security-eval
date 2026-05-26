// xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, true);
// xif.setProperty(XMLInputFactory.SUPPORT_DTD, true);
// // Skep 'n XMLStreamReader met die onveilige konfigurasie
// XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));
// // Ontleed die XML met behulp van die gekonfigureerde stroomleser
// return (UserProfile) unmarshaller.unmarshal(xsr);
// } catch (JAXBException | XMLStreamException e) {
// // In geval van ontledingsfoute, teken die uitsondering aan en keer null terug.
// // Dit verhoed dat misvormde XML die toepassing laat breek.
// System.err.println("Kon nie XML-data verwerk nie: " + e.getMessage());
// return null;
// }
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
