import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class XPathExtractor {
    public static void main(String[] args) {
        try {
            // Load XML file
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Create XPath object
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Dynamic XPath expression (example)
            String xpathExpression = "//book[price>35]/title";

            // Compile and evaluate XPath expression
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            // Extract values
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Value: " + nodeList.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}