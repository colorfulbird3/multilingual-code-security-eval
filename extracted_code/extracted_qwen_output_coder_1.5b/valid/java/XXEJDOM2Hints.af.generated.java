import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class XMLDataParser {
    public static String parseXML(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlContent));
            Document doc = builder.parse(is);
            
            NodeList messageList = doc.getElementsByTagName("message");
            if (messageList.getLength() > 0) {
                Element messageElement = (Element) messageList.item(0);
                return messageElement.getTextContent();
            }
            
            NodeList errorList = doc.getElementsByTagName("error");
            if (errorList.getLength() > 0) {
                Element errorElement = (Element) errorList.item(0);
                return errorElement.getTextContent();
            }
            
            return "";
        } catch (Exception e) {
            return "Error parsing XML: " + e.getMessage();
        }
    }
}