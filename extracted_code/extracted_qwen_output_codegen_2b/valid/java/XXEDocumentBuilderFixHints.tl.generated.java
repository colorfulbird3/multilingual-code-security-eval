```java
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlParser {
    public Document parseXml(String xmlContent) throws ParsingException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlContent));
            return builder.parse(is);
        } catch (SAXException e) {
            throw new ParsingException("Error parsing XML", e);
        } catch (IOException e) {
            throw new Error("IO error occurred", e);
        } catch (ParserConfigurationException e) {
            throw new Error("Parser configuration error", e);
        }
    }
}
```