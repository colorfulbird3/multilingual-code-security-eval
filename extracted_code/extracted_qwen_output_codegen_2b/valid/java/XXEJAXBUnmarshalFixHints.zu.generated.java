```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class XmlToObjectConverter {
    public static UserProfile convertXmlToUserProfile(String xmlData) throws JAXBException, XMLStreamException {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));
        JAXBContext context = JAXBContext.newInstance(UserProfile.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (UserProfile) unmarshaller.unmarshal(xsr);
    }
}
```