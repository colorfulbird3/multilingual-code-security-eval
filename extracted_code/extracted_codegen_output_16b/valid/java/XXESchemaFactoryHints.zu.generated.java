```java
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class XmlProcessingService {
    private SchemaFactory schemaFactory;
    
    public XmlProcessingService() {
        this.schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
    }
    
    public boolean validateXmlAgainstXsd(String xmlFilePath, String xsdFilePath) {
        try {
            Schema schema = schemaFactory.newSchema(new StreamSource(new File(xsdFilePath)));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setSchema(schema);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlFilePath));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
```