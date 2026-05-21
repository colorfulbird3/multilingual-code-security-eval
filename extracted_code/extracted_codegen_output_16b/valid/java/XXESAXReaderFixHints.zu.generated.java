```java
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLParser {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("example.xml");
            System.out.println("XML file parsed successfully");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
```