```java
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class XMLValidator {
    public static void validateXML(String xmlContent, String xsdContent) throws Exception {
        // Create SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        
        // Create Schema from XSD content
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        StreamSource xsdSource = new StreamSource(new StringReader(xsdContent));
        Schema schema = schemaFactory.newSchema(xsdSource);
        
        // Set schema on factory
        factory.setSchema(schema);
        
        // Create SAXParser
        SAXParser parser = factory.newSAXParser();
        
        // Create DefaultHandler for validation
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void error(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException {
                throw e;
            }
        };
        
        // Parse and validate XML
        InputSource inputSource = new InputSource(new StringReader(xmlContent));
        parser.parse(inputSource, handler);
        
        // Alternative validation using JAXB
        JAXBContext jaxbContext = JAXBContext.newInstance("com.example.model");
        JAXBSource jaxbSource = new JAXBSource(jaxbContext, null);
        
        // Create Validator
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new StringReader(xmlContent)));
    }
}
```