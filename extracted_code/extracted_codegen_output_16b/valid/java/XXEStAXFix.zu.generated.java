public class SchemaValidationService {

    //...

    public boolean validateSchema(String schemaContent) {
        XMLSchemaFactory factory = XMLSchemaFactory.newInstance();
        try {
            return factory.newSchema(new Source[] {new StreamSource(new StringReader(schemaContent))}).newValidator().validate(new StreamSource(new StringReader(schemaContent)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
    }
}