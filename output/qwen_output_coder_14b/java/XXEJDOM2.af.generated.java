Hier is die implementering van die `XmlDataParser`-klas met die `parse`-metode gebruikmakende van die JDOM2-biblioteek:

```java
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | NullPointerException e) {
            // Handle exceptions such as invalid XML format or missing elements
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return null;
    }
}
```

### Uitleg van die Implementering:

1. **Pakketnaam**: Die klas word geplaas in die `com.example.webapp.service` pakket.

2. **Klasnaam**: Die klas het die naam `XmlDataParser`.

3. **Metode-handtekening**: Die `parse`-metode het die handtekening `public String parse(String xmlContent) throws Exception`.

4. **XML Ontlêding**:
   - `SAXBuilder saxBuilder = new SAXBuilder();`: Hiermee word 'n nuwe `SAXBuilder`-objek geskep om die XML te ontleed.
   - `Document document = saxBuilder.build(new StringReader(xmlContent));`: Die XML-teks word ingelees en 'n `Document`-objek word geskep.
   - `Element rootElement = document.getRootElement();`: Die wortel-element van die XML-dokument word verkry.
   - `Element messageElement = rootElement.getChild("message");`: Die kind-element met die naam `<message>` word opgehaal.

5. **Teksonttrekking**:
   - `return messageElement.getTextTrim();`: Die teksinhoud van die `<message>`-element word teruggegee na dat spatievoorspelleing en wysbrukteken verwijder word.

6. **Uitsonderingshantering**:
   - `catch (JDOMException | NullPointerException e)`: Dit kapture oor XML-ongeldighede of elemente wat nie bestaan nie.
   - `System.err.println("Error parsing XML: " + e.getMessage());`: 'n Foutbericht word getoond op die foutuitvoer.

7. **Null-retour**:
   - Indien die XML ongeldig is of die `<message>`-element nie bestaan nie, word `null` teruggegee.

Hier is die kode in die gevraagde XML-formaat:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/webapp/service/XmlDataParser.java
        </path>
        <content>
            <![CDATA[
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | NullPointerException e) {
            // Handle exceptions such as invalid XML format or missing elements
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return null;
    }
}
            ]]>
        </content>
    </code>
</result>
```