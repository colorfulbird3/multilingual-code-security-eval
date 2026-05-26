import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.StringReader;
import java.io.IOException;

public class XMLSchemaValidator {

    public static boolean validateXMLSchema(String schemaContent, String xmlContent) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaSource = new StreamSource(new StringReader(schemaContent));
            Schema schema = factory.newSchema(schemaSource);
            Validator validator = schema.newValidator();
            Source xmlSource = new StreamSource(new StringReader(xmlContent));
            validator.validate(xmlSource);
            return true;
        } catch (SAXException | IOException e) {
            System.err.println("Validation error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String schema = "<?xml version=\"1.0\"?>\n" +
                "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "  <xs:element name=\"note\">\n" +
                "    <xs:complexType>\n" +
                "      <xs:sequence>\n" +
                "        <xs:element name=\"to\" type=\"xs:string\"/>\n" +
                "        <xs:element name=\"from\" type=\"xs:string\"/>\n" +
                "        <xs:element name=\"heading\" type=\"xs:string\"/>\n" +
                "        <xs:element name=\"body\" type=\"xs:string\"/>\n" +
                "      </xs:sequence>\n" +
                "    </xs:complexType>\n" +
                "  </xs:element>\n" +
                "</xs:schema>";

        String xml = "<?xml version=\"1.0\"?>\n" +
                "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        boolean isValid = validateXMLSchema(schema, xml);
        System.out.println("XML is valid: " + isValid);
    }
}