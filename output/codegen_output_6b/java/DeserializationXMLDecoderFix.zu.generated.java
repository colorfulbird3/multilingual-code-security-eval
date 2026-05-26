


## Ekukosana

Dela ikhodi elungisiwe ye-Java.

```java
public class ConfigurationLoaderService {
    public static String loadConfiguration(String xmlData) {
        // Dala i-decoder ukuze ufunde into esuka kumfula we-XML.
        XMLDecoder decoder = new XMLDecoder(
            new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))
        );
        // Funda ubuyisele into ehlukanisiwe.
        Object result = decoder.readObject();
        decoder.close();
        return result.toString();
    }
}
```