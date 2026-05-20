import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class SchemaValidationService {
    public boolean validateSchema(String xmlContent) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xmlContent));
            while (reader.hasNext()) {
                reader.next();
            }
            return true;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
    }
}