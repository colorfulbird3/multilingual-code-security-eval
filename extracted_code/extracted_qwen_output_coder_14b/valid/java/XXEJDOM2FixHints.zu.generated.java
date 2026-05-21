import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.EntityResolver;
import java.io.StringReader;
import java.io.IOException;

public class SecureXmlDataParser {

    public String parse(String xmlContent) throws IOException, SAXException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        
        // Disable external entities
        builder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        builder.setFeature("http://xml.org/sax/features/external-general-entities", false);
        builder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        builder.setProperty("http://apache.org/xml/properties/security-manager", new SecurityManager());

        // Set a dummy entity resolver to prevent DTD resolution
        builder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(new StringReader(""));
            }
        });

        // Parse the XML
        Document doc = builder.build(new StringReader(xmlContent));
        Element root = doc.getRootElement();
        Element messageElement = root.getChild("message");
        return messageElement != null ? messageElement.getText() : null;
    }

    private static class SecurityManager {
        public void checkEntityCount(int count) {
            if (count > 0) {
                throw new RuntimeException("External entity reference is not allowed.");
            }
        }
    }
}