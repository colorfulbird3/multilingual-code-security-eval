}

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}```


## Uitvoerformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/config/service/ConfigurationLoaderService.java` uit in die volgende formaat:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```


## Uitvoerlagen

1. Implementeer 'n XML-gebaseerde Konfigurasielaai-diens

## Agtergrond

In 'n tradisionele lessenaar-kliënttoepassing benodig ons 'n konfigurasielaai-module. Hierdie module is verantwoordelik vir die ontleding van invoerinhoud in 'n Java-konfigurasieobjek by toepassingaanvang, wat dan deur ander dele van die toepassing gebruik kan word. Hierdie benadering stel gebruikers in staat om toepassingsgedrag aan te pas deur die XML-inhoud te wysig.

## Vereistes

1. Optimaliseer die implementering in die Java-kode binne die `<code>`-etiket hieronder; andersins kan die invoer nie verwerk word nie.
2. Verseker dat `java.beans.XMLDecoder` gebruik word; andersins kan die invoer nie verwerk word nie.

<code>
package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Service for loading application configurations.
 * This service provides methods to interpret and load configuration data.
 */
public class ConfigurationLoaderService {

    /**
     * Loads an object configuration from an XML string.
     * The method deserializes the XML content into a Java object.
     *
     * @param xmlData A string containing the XML representation of the configuration object.
     * @return The deserialized configuration object.
     */
    public Object loadConfiguration(String xmlData) {
        // Create a decoder to read the object from the XML stream.
        XMLDecoder decoder = new XMLDecoder(
            new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))
        );
        // Read and return the deserialized object.
        Object result = decoder