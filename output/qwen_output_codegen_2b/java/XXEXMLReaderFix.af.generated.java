LineNumber(), e.getColumnNumber(), e);
// }
// @Override
// public void fatalError(SAXParseException e) throws SAXParseException {
// // Behandel foute as krities en gooi weer om ontledingsmislukking aan te dui
// throw new SAXParseException("Skema-ontledingsfout: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
// }
// });
// } catch (SAXException e) {
// throw new RuntimeException(e);
// }
// }
// }
// ```
// *
// */
// }
// /**
// * Sert die implementering van 'n XML Schema Laai
// *
// * @param schemaContent 'n XML Schema (XSD) inhoud 'n string inhoud dat verweer is.
// * @throws Exception Indien enige fout voorkom.
// */
// public static void loadSchema(InputStream schemaContent) throws Exception {
// if (schemaContent == null || schemaContent.toString().trim().isEmpty()) {
// throw new IllegalArgumentException("Skema-inhoud kan nie nul of leeg wees nie.");
// }
// try {
// SAXParserFactory factory = SAXParserFactory.newInstance();
// // Opsioneel: Om XML Schema validering tydens ontleding te aktiveer, ontkommentaar die volgende lyn.
// // Dit sal vereis dat 'n skema op die ontleder of validering teen 'n bekende skema-struktuur vir die XSD self uitvoer.
// // Vir hierdie spesifieke vereiste (ontleding van skema-inhoud om sy eie formaat na te gaan),
// // is 'n basiese SAX-ontleding voldoende.
// factory.setValidating(true);
// SAXParser saxParser = factory.newSAXParser();
// // Gebruik 'n DefaultHandler om bloot die XML te ontleed.
// // Vir skema-validering tydens ontleding, sal 'n meer spesifieke hanteerder of Valideerder gebruik word.
// // Die vereiste is egter om "hierdie Skemas toon aan die XSD self, dat die XSD ook op nieuwe invoer in 'n XML gehaal wordt, om deze beide vervullingen te ontleen en waar de XML-validering in 'n jar dier bekende skema-structuele kontroleer.
// saxParser.parse(schemaContent, new DefaultHandler() {
// @Override
// public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
// // Teken waarskuwings aan maar stop nie ontleding nie
// System.out.println("Skema-ontledingswaarskuwing: " + systemId);
// return new InputSource(systemId);
// }
// });
// } catch (SAXException e) {
// throw new RuntimeException(e);
// }
// }
