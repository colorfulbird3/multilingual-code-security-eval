public class ConfigurationLoaderService {

    public Object loadConfiguration(String xmlData) {

        if (xmlData == null) {
            return new UserPreferences();
        }

        try {
            // Create a new XMLDecoder
            XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(xmlData.getBytes()));
            Object result = decoder.readObject();
            return result;
        }
        catch (Exception e) {
            return new UserPreferences();
        }
    }
}