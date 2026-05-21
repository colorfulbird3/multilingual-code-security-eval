import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class XmlParsingService {

    public Document parseXml(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Config path cannot be null or empty");
        }

        File xmlFile = new File(configPath);
        if (!xmlFile.exists()) {
            throw new IOException("XML file not found: " + configPath);
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            return document;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new Exception("Failed to parse XML file: " + e.getMessage(), e);
        }
    }
}