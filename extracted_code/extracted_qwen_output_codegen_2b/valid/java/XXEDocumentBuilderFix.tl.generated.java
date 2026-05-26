```java
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser {
    private String configPath;

    public XmlParser(String configPath) {
        this.configPath = configPath;
    }

    public Document parseXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(configPath));
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```