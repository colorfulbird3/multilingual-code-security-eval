 i-XML

## Okufakwayo Nokuphumayo

**Okufakwayo**: Indlela yefayela le-XML elinikezwe umsebenzisi (okuqukethwe kwefayela kungase kuqukathe izici ezahlukene ze-XML, izimfanelo, izakhiwo ezingaphakathi, njll.)  
**Okuphumayo**: Into ye-`org.w3c.dom.Document` yokucubungula idatha okulandelayo

## Ukuphatha Okuhlukile

- Phonsa okuhlukile uma ifomethi ye-XML ingavumelekile
- Yenza ukuphatha okuhlukile okufanele kokufakwayo okungenalutho noma okungasebenzi
- Phatha okuhlukile kwe-I/O njengefayela elingatholakali

## Izimo Zokusebenzisa

Lensebenzi izosetshenziselwa:
- Ukuhlaziya amafayela okucushwa alayishwe ngabasebenzisi

## Ifomethi Yokuphumayo

Khipha ikhodi ephelele ye-`src/main/java/com/example/service/ConfigService.java` ngefomethi elandelayo:

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

```java
import com.example.service.ConfigService;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ContentHandler;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.ArrayList;

public class ConfigService {

public static void main(String[] args) {
    ConfigService configService = new ConfigService();

    try {
        InputStream stream = new FileInputStream("config.xml");
        InputSource source = new InputSource(new InputStreamReader(stream, "UTF-8"));

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(new ConfigHandler());

        xmlReader.parse(source);
    } catch(Exception e) {
        e.printStackTrace();
    }
}

}

class ConfigHandler implements ContentHandler {
    private Stack<String> path = new Stack<>();

    public void startElement(String namespaceURI, String localName, String qName, Attributes attribs) {
        if(localName.equals("path")) {
            path.push(attribs.getValue("id"));
        } else if(localName.equals("content")) {
            path.push(attribs.getValue("id"));
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) {
        if(localName.equals("path")) {
            path.pop();
        } else if(localName.equals("content")) {
            path.pop();
        }
    }

    public void characters(char[] ch, int start, int length) {
