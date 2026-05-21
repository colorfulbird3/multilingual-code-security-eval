```java
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;

public class XmlValidator {

    public boolean validateXml(String xmlInput) {
        if (xmlInput == null || xmlInput.trim().isEmpty()) {
            return false;
        }
        Digester digester = new Digester();
        digester.setValidating(false);
        try {
            digester.parse(new StringReader(xmlInput));
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}
```