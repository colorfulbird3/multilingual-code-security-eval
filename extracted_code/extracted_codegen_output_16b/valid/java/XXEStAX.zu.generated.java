```java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XMLValidator {

    public static void main(String[] args) {
        String xmlFilePath = "input.xml";
        String xsdFilePath = "schema.xsd";

        try {
            // Validate XML against XSD
            boolean isValid = validateXMLSchema(xsdFilePath, xmlFilePath);
            if (isValid) {
                System.out.println("XML is valid against XSD.");
            } else {
                System.out.println("XML is NOT valid against XSD.");
            }

            // Parse XML using DOM parser
            Document doc = parseXML(xmlFilePath);
            if (doc != null) {
                // Example: Print all element names
                printElementNames(doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(parseXML(xmlPath)));
            return true;
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Validation error: " + e.getMessage());
            return false;
        }
    }

    public static Document parseXML(String filePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(filePath));
    }

    public static void printElementNames(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element: " + nodeList.item(i).getNodeName());
        }
    }
}
```