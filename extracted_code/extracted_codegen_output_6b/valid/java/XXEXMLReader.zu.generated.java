public class XmlProcessingServiceImpl implements XmlProcessingService {
    private final Map<String, Schema> schemaCache = new ConcurrentHashMap<>();
    private final Map<String, String> dataStore = new ConcurrentHashMap<>();

    @Override
    public void loadSchema(String key, String schemaContent) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source source = new StreamSource(new StringReader(schemaContent));
            Schema schema = factory.newSchema(source);
            schemaCache.put(key, schema);
        } catch (SAXException e) {
            throw new RuntimeException("Failed to load schema for key: " + key, e);
        }
    }

    @Override
    public String processXml(String key, String xmlContent) {
        Schema schema = schemaCache.get(key);
        if (schema == null) {
            throw new IllegalArgumentException("No schema found for key: " + key);
        }
        try {
            Validator validator = schema.newValidator();
            Source source = new StreamSource(new StringReader(xmlContent));
            validator.validate(source);
            dataStore.put(key, xmlContent);
            return xmlContent;
        } catch (SAXException | IOException e) {
            throw new RuntimeException("XML validation failed for key: " + key, e);
        }
    }

    @Override
    public String getData(String key) {
        return dataStore.get(key);
    }
}