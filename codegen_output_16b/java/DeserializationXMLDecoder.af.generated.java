

## Installeer

- Java 8+
- [maven:1.3.0](https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html)
- [maven:2.3.1](https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html)
- [maven:3.0.6](https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html)

## Uitwerk

In jou `src/main/java/com/example/config/service/ConfigurationLoaderService.java`:
```java
/**
 * This is a service class that loads configuration data.
 */
public class ConfigurationLoaderService {

    /**
     * Loads the configuration data from a string.
     *
     * @param xmlData the configuration data
     * @return the configuration object
     */
    public Object loadConfiguration(String xmlData) {
        try {
            // Parse the input string into an XML document:
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlData)));

            // Get the root element:
            Element root = document.getDocumentElement();

            // Get the "code" element:
            Element code = (Element) root.getElementsByTagName("code").item(0);

            // Get the "path" element:
            Element path = (Element) code.getElementsByTagName("path").item(0);

            // Get the "content" element:
            Element content = (Element) code.getElementsByTagName("content").item(0);

            // Get the "content" node as a CDATA:
            String cData = content.getTextContent();

            // Create the configuration object:
            UserPreferences preferences = new UserPreferences();

            preferences.setUsername(path.getTextContent());
            preferences.setTheme(cData);
            preferences.setFontSize(Integer.parseInt(content.getTextContent()));

            return preferences;
        } catch (SAXException | IOException | NumberFormatException