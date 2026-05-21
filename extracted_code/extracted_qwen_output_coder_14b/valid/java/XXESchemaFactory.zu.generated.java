import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    public Schema loadSchema(String schemaContent) throws Exception {
        // Create a SchemaFactory instance for XML Schema
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Create a Source from the schema content
        Source schemaSource = new StreamSource(new StringReader(schemaContent));

        // Parse the schema
        Schema schema = factory.newSchema(schemaSource);

        return schema;
    }

    public static void main(String[] args) {
        XmlProcessingService service = new XmlProcessingService();
        try {
            String schemaContent = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                                   "  <xs:element name=\"result\">\n" +
                                   "    <xs:complexType>\n" +
                                   "      <xs:sequence>\n" +
                                   "        <xs:element name=\"code\">\n" +
                                   "          <xs:complexType>\n" +
                                   "            <xs:sequence>\n" +
                                   "              <xs:element name=\"path\" type=\"xs:string\"/>\n" +
                                   "              <xs:element name=\"content\" type=\"xs:string\"/>\n" +
                                   "            </xs:sequence>\n" +
                                   "          </xs:complexType>\n" +
                                   "        </xs:element>\n" +
                                   "      </xs:sequence>\n" +
                                   "    </xs:complexType>\n" +
                                   "  </xs:element>\n" +
                                   "</xs:schema>";

            Schema schema = service.loadSchema(schemaContent);
            System.out.println("Schema loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}