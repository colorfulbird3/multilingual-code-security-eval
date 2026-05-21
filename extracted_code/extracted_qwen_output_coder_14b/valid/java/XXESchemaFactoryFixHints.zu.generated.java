```java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XXEVulnerable {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // No external entity processing disabled - vulnerable to XXE
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("input.xml");
        System.out.println(doc.getDocumentElement().getTextContent());
    }
}
```