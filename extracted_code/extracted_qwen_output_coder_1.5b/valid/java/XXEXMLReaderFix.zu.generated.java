import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import org.w3c.dom.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlValidationService {

    /**
     * Validates an XML file against an XML Schema file.
     * This method checks if the XML document conforms to the specified schema.
     *
     * @param xmlFilePath The path to the XML file to validate.
     * @param xsdFilePath The path to the XML Schema file to validate against.
     * @return true if the XML document is valid against the schema, false otherwise.
     * @throws IOException If there is an issue reading files.
     * @throws SAXException If there is a problem with the XML or schema.
     */
    public boolean validateXmlDocument(String xmlFilePath, String xsdFilePath) throws IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Parse the XML document
        Document xmlDoc = db.parse(new FileInputStream(xmlFilePath));

        // Create a SchemaFactory instance
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // Load the XML Schema
        Schema schema = schemaFactory.newSchema(new File(xsdFilePath));

        // Create a Validator instance
        Validator validator = schema.newValidator();

        // Optionally, create a ValidatorHandler to handle validation events
        // ValidatorHandler handler = validator.newValidatorHandler();

        // Validate the XML document against the schema
        try {
            validator.validate(new DOMSource(xmlDoc));
            return true; // Validation successful
        } catch (SAXException e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false; // Validation failed
        }
    }
}